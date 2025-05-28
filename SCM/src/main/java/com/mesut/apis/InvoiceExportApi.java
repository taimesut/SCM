package com.mesut.apis;

import com.mesut.configs.PayOsConfig;
import com.mesut.pojo.DetailReceiptExport;
import com.mesut.pojo.InvoiceExport;
import com.mesut.pojo.Product;
import com.mesut.pojo.ReceiptExport;
import com.mesut.services.DetailReceiptExportService;
import com.mesut.services.InvoiceExportService;
import com.mesut.services.ProductService;
import com.mesut.services.ReceiptExportService;
import com.mesut.services.UserService;
import com.mesut.services.WarehouseService;
import com.mesut.utils.CreateDateUtils;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/secure/payment")
public class InvoiceExportApi extends GenericApi<InvoiceExport> {

    private final InvoiceExportService ieService;

    @Autowired
    public InvoiceExportApi(InvoiceExportService service) {
        super(service);
        this.ieService = service;
    }

    @Autowired
    public UserService userService;

    @Autowired
    public WarehouseService wareService;

    @Autowired
    public DetailReceiptExportService detailRCExport;

    @Autowired
    public ProductService prodService;

    @Autowired
    public ReceiptExportService reService;

    public String hmacSha256(String data, String secret) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        byte[] hashBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

        StringBuilder hashString = new StringBuilder();
        for (byte b : hashBytes) {
            hashString.append(String.format("%02x", b));
        }
        return hashString.toString();
    }

    private InvoiceExport createInvoiceExport(Integer orderCode, Integer amount, String description, String paymentMethod,
            List<Map<String, Object>> items, Principal principal) throws Exception {
        // Tạo ReceiptExport
        ReceiptExport re = new ReceiptExport();
        re.setCustomerId(this.userService.getUserByUsername(principal.getName()));
        re.setStatus(ReceiptStatus.ORDERED);
        re.setNote("BBBBBB");
        re.setWarehouseId(this.wareService.getById(1));
        this.reService.addOrUpdate(re);

        // Tạo InvoiceExport
        InvoiceExport ie = new InvoiceExport();
        ie.setNote(description);
        ie.setStatus(PaymentStatus.PENDING);
        ie.setTotal(amount);
        ie.setPaymentMethod(paymentMethod);
        ie.setReceiptExportId(re);
        ie.setOrderCode(orderCode);
        ie.setCreateDate(CreateDateUtils.createDate());
        this.ieService.addOrUpdate(ie);

        // Tạo DetailReceiptExport cho từng item
        if (items != null && !items.isEmpty()) {
            for (Map<String, Object> item : items) {
                Integer id = Integer.valueOf(item.get("id").toString());
                Integer price = Integer.valueOf(item.get("price").toString());
                Integer quantity = Integer.valueOf(item.get("quantity").toString());

                Product p = prodService.getById(id);

                DetailReceiptExport dre = new DetailReceiptExport();
                dre.setAmount(quantity);
                dre.setPrice(price);
                dre.setProductId(p);
                dre.setReceiptExportId(re);

                this.detailRCExport.addOrUpdate(dre);
            }
        }

        return ie;
    }

    // Thanh toán ngân hàng (chuyển khoản)
    @PostMapping("/payos")
    public ResponseEntity<?> createPayment(@RequestBody Map<String, Object> request, Principal principal) {
        System.out.println("Received payment request: " + request);

        try {
            Integer orderCode = (Integer) request.get("orderCode");
            Integer amount = ((Number) request.get("amount")).intValue();
            String description = (String) request.get("description");
            String cancelUrl = (String) request.get("cancelUrl");
            String returnUrl = (String) request.get("returnUrl");
            String paymentMethod = (String) request.get("paymentMethod");
            List<Map<String, Object>> items = (List<Map<String, Object>>) request.get("items");

            if (orderCode == null || amount == null || amount <= 0 || cancelUrl == null || returnUrl == null || paymentMethod == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Thiếu trường dữ liệu bắt buộc"));
            }

            String data = String.format("amount=%d&cancelUrl=%s&description=%s&orderCode=%d&returnUrl=%s",
                    amount, cancelUrl, description, orderCode, returnUrl);

            String signature = hmacSha256(data, PayOsConfig.checksumKey);

            Map<String, Object> payload = new HashMap<>();
            payload.put("orderCode", orderCode);
            payload.put("amount", amount);
            payload.put("description", description);
            payload.put("signature", signature);
            payload.put("cancelUrl", cancelUrl);
            payload.put("returnUrl", returnUrl);
            if (items != null && !items.isEmpty()) {
                payload.put("items", items);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.set("x-client-id", PayOsConfig.clientId);
            headers.set("x-api-key", PayOsConfig.apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Map> response = restTemplate.exchange(
                    PayOsConfig.endpoint,
                    HttpMethod.POST,
                    entity,
                    Map.class
            );

            if (!response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.status(response.getStatusCode())
                        .body(Map.of("error", "Thanh toán thất bại", "details", response.getBody()));
            }

            Map<String, Object> payosResponseBody = response.getBody();

            // Ghi nhận vào hệ thống
            createInvoiceExport(orderCode, amount, description, paymentMethod, items, principal);

            return ResponseEntity.ok(payosResponseBody);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Lỗi tạo thanh toán", "message", e.getMessage()));
        }
    }

    // Thanh toán tiền mặt (COD)
    @PostMapping("/cod")
    public ResponseEntity<?> createPaymentCod(@RequestBody Map<String, Object> request, Principal principal) {
        try {
            Integer orderCode = (Integer) request.get("orderCode");
            Integer amount = ((Number) request.get("amount")).intValue();
            String description = (String) request.get("description");
            String cancelUrl = (String) request.get("cancelUrl");
            String returnUrl = (String) request.get("returnUrl");
            String paymentMethod = (String) request.get("paymentMethod");
            List<Map<String, Object>> items = (List<Map<String, Object>>) request.get("items");

            if (orderCode == null || amount == null || amount <= 0 || cancelUrl == null || returnUrl == null || paymentMethod == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Thiếu trường dữ liệu bắt buộc"));
            }
            InvoiceExport ie = createInvoiceExport(orderCode, amount, description, paymentMethod, items, principal);

            return ResponseEntity.ok(Map.of(
                    "message", "Tạo đơn hàng thành công",
                    "invoiceExportId", ie.getId()
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Lỗi tạo thanh toán", "message", e.getMessage()));
        }
    }

    @PutMapping("/update-invoice")
    public ResponseEntity<?> updateInvoice(@RequestBody Map<String, String> request, Principal principal) {
        if (principal == null) {
            System.out.println("loi o day");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(this.ieService.updateInvoice(request, principal));
    }

}

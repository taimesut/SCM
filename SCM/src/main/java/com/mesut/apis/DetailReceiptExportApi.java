package com.mesut.apis;

import com.mesut.pojo.DetailReceiptExport;
import com.mesut.pojo.Product;
import com.mesut.pojo.ReceiptExport;
import com.mesut.pojo.User;
import com.mesut.services.DetailReceiptExportService;
import com.mesut.services.ProductService;
import com.mesut.services.ReceiptExportService;
import com.mesut.services.UserService;
import com.mesut.services.WarehouseService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TAN TAI
 */
@RestController
@RequestMapping("/api/secure/detail-receipt-export")
public class DetailReceiptExportApi extends GenericApi<DetailReceiptExport> {

    private final DetailReceiptExportService detailRCExport;
    @Autowired
    public DetailReceiptExportApi(DetailReceiptExportService service) {
        super(service);
        this.detailRCExport = service;
    }

    @Autowired
    public ProductService prodService;

    @Autowired
    public ReceiptExportService rpExportService;

    @Autowired
    public WarehouseService wareService;

    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createDetailReceiptExport(@RequestBody List<Map<String, Object>> items, Principal principal) {
        if (items == null || items.isEmpty()) {
            return ResponseEntity.badRequest().body("Danh sách sản phẩm rỗng.");
        }

        User u = this.userService.getUserByUsername(principal.getName());

        ReceiptExport re = new ReceiptExport();
        re.setCustomerId(u);
        re.setNote("Hello");
        re.setStatus(Status.ORDERED);
        re.setWarehouseId(this.wareService.getById(1));
        this.rpExportService.addOrUpdate(re);

        for (Map<String, Object> item : items) {
            Integer id = Integer.valueOf(item.get("id").toString());
            Integer amount = Integer.valueOf(item.get("quantity").toString());

            Product p = prodService.getById(id);

            DetailReceiptExport dre = new DetailReceiptExport();
            dre.setAmount(amount);
            dre.setPrice(p.getPrice());
            dre.setProductId(p);
            dre.setReceiptExportId(re);

            this.detailRCExport.addOrUpdate(dre);
        }

        return ResponseEntity.ok("Tạo đơn hàng thành công!!");
    }


    @GetMapping("/user-receipt")
    public ResponseEntity<?> getUserOrders(Principal principal) {
        User u = this.userService.getUserByUsername(principal.getName());
        if (u != null)
            return ResponseEntity.ok(this.detailRCExport.getDetailReceiptExportsByUserId(u.getId()));
        else
            return ResponseEntity.status(400).build();
    }
}

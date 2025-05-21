/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.constants.RepositoryConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author THANHTAIPC
 */
@ControllerAdvice
public class GlobalModelAttribute {

    private Map<String, String> getItemMenu() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("/category", "Danh mục");// xong
        menu.put("/delivery-schedule", "Lịch vận chuyển");// xong
        menu.put("/detail-receipt-export", "Chi tiết Phiếu xuất");// xong
        menu.put("/detail-receipt-import", "Chi tiết Phiếu nhập");// xong
        menu.put("/inventory", "Tồn kho");// xong
        menu.put("/invoice-export", "Hóa đơn xuất");// xong
        menu.put("/log-inventory", "Lịch sử kho");
        menu.put("/product", "Sản phẩm");// xong
        menu.put("/receipt-export", "Phiếu xuất");// xong
        menu.put("/receipt-import", "Phiếu nhập");// xong
        menu.put("/review-shipment-company", "Đánh giá đối tác vận chuyển");// xong
        menu.put("/review-supplier", "Đánh giá nhà cung cấp");// xong
        menu.put("/shipment-company-contact", "Điều kiện hợp tác");// xong
        menu.put("/shipment-company", "Đối tác vận chuyển");// xong
        menu.put("/shipment", "Vận chuyển");// xong
        menu.put("/supplier", "Nhà cung cấp");// xong
        menu.put("/stats", "Thống kê");// xong
        menu.put("/user", "Người dùng");// xong
        menu.put("/warehouse", "Kho hàng");// xong
        return menu;
    }

    private Map<String, String> getIcon() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("update", "<i class='fa fa-wrench'></i>");
        menu.put("delete", "<i class='fa fa-trash'></i>");
        return menu;
    }

    private List<String> g_user_user_role() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        roles.add("ROLE_ADMIN");
        return roles;
    }

    private List<String> g_invoice_export_payment_method() {
        List<String> roles = new ArrayList<>();
        roles.add("Chuyển Khoản");
        roles.add("Tiền mặt");
        return roles;
    }

    private List<String> g_delivery_schedule_status() {
        List<String> roles = new ArrayList<>();
        roles.add("Đã tới");
        roles.add("Chưa tới");
        return roles;
    }

    private List<String> g_invoice_export_status() {
        List<String> roles = new ArrayList<>();
        roles.add("Chưa thanh toán");
        roles.add("Đã thanh toán");
        return roles;
    }

    private List<String> g_receipt_import_status() {
        List<String> roles = new ArrayList<>();
        roles.add("Đã xác nhận");
        roles.add("Chưa xác nhận");
        roles.add("Đã hủy");
        return roles;
    }

    private List<String> g_receipt_export_status() {
        List<String> roles = new ArrayList<>();
        roles.add("Đã xác nhận");
        roles.add("Chưa xác nhận");
        roles.add("Đã hủy");
        return roles;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
//        Không sửa, không được đụng vào
        model.addAttribute("g_prefix", PrefixUrl.PREFIX_URL);
        model.addAttribute("g_icons", this.getIcon());
        model.addAttribute("g_list_item_menu", this.getItemMenu());
        model.addAttribute("g_avatar_default", "https://res.cloudinary.com/demfjaknk/image/upload/v1747309030/z5gy3lsqjvck0bvgc5e1.png");

//        g_TênBảng_TrườngDữLiệu
        model.addAttribute("g_user_user_role", this.g_user_user_role());

        model.addAttribute("g_delivery_schedule_status", this.g_delivery_schedule_status());

        model.addAttribute("g_shipment_status", this.g_delivery_schedule_status());

        model.addAttribute("g_invoice_export_payment_method", this.g_invoice_export_payment_method());
        model.addAttribute("g_invoice_export_status", this.g_invoice_export_status());

        model.addAttribute("g_receipt_import_status", this.g_receipt_import_status());

        model.addAttribute("g_receipt_export_status", this.g_receipt_export_status());

    }
}

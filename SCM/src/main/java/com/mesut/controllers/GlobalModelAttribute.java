/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.services.CategoryService;
import com.mesut.utils.PrefixUrl;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author THANHTAIPC
 */
@ControllerAdvice
public class GlobalModelAttribute {

    @Autowired
    private CategoryService categoryService;

    private Map<String, String> getItemMenu() {
        Map<String, String> menu = new LinkedHashMap<>(); // Giữ đúng thứ tự thêm vào
        menu.put("/category", "Danh mục");
        menu.put("/delivery-schedule", "Lịch vận chuyển");
        menu.put("/detail-receipt", "Chi tiết phiếu");
        menu.put("/inventory", "Tồn kho");
        menu.put("/invoice", "Hóa đơn");
        menu.put("/log-inventory", "Lịch sử kho");
        menu.put("/product", "Sản phẩm");
        menu.put("/purpose", "Mục đích nhập/xuất");
        menu.put("/receipt", "Phiếu nhập/xuất");
        menu.put("/review-shipment-company", "Đánh giá đối tác vận chuyển");
        menu.put("/review-supplier", "Đánh giá nhà cung cấp");
        menu.put("/shipment-company-contact", "Điều kiện hợp tác");
        menu.put("/shipment-company", "Đối tác vận chuyển");
        menu.put("/shipment", "Vận chuyển");
        menu.put("/supplier", "Nhà cung cấp");
        menu.put("/user", "Người dùng");
        menu.put("/warehouse", "Kho hàng");
        return menu;
    }

    private Map<String, String> getIcon() {
        Map<String, String> menu = new LinkedHashMap<>(); // Giữ đúng thứ tự thêm vào
        menu.put("update", "<i class='fa fa-wrench'></i>");
        menu.put("delete", "<i class='fa fa-trash'></i>");
        return menu;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("g_list_category", this.categoryService.getList());
        model.addAttribute("g_list_item_menu", this.getItemMenu());
        model.addAttribute("g_prefix", PrefixUrl.PREFIX_URL);
        model.addAttribute("g_icons", this.getIcon());

    }
}

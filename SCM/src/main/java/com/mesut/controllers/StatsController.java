/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.services.StatsService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class StatsController {

    private final int EXPIRING_DAY = 30;

    @Autowired
    private StatsService mainService;

    private List<Object[]> getListCurrentInventory() {
        return this.mainService.currentInventory().stream()
                .filter(row -> {
                    try {
                        Integer amount = Integer.valueOf(row[3].toString());
                        Integer min = Integer.valueOf(row[4].toString());
                        return amount < min;
                    } catch (Exception e) {
                        System.out.println(e);
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    private List<Object[]> getListExpiringInventory() {
        return this.mainService.expiringInventory(this.EXPIRING_DAY);
    }

    private List<Object[]> getListExpiredInventory() {
        return this.mainService.expiredInventory();
    }

    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("list_current", this.getListCurrentInventory());
        model.addAttribute("list_expiring", this.getListExpiringInventory());
        model.addAttribute("list_expiried", this.getListExpiredInventory());
    }

    @GetMapping("/admin/stats")
    public String statsView(Model model) {
        List<Object[]> data = this.mainService.danhGiaHieuSuatNhaCungCap();

        List<String> names = new ArrayList<>();
        List<Long> totalReceipts = new ArrayList<>();
        List<Double> avgPrice = new ArrayList<>();
        List<Double> avgQuality = new ArrayList<>();
        List<Double> avgSupport = new ArrayList<>();

        for (Object[] row : data) {
            names.add((String) row[1]);
            totalReceipts.add(((Long) row[2]));
            avgPrice.add((Double) row[3]);
            avgQuality.add((Double) row[4]);
            avgSupport.add((Double) row[5]);
        }

        model.addAttribute("names", names);
        model.addAttribute("totalReceipts", totalReceipts);
        model.addAttribute("avgPrice", avgPrice);
        model.addAttribute("avgQuality", avgQuality);
        model.addAttribute("avgSupport", avgSupport);
        return "stats";
    }

    @GetMapping("/admin/stats/current-inventory")
    public String currentInventoryView(Model model) {
        return "stats/current-inventory";
    }

    @GetMapping("/admin/stats/expiring-inventory")
    public String expiringInventoryView(Model model) {
        return "stats/expiring-inventory";
    }

    @GetMapping("/admin/stats/expired-inventory")
    public String expiredInventoryView(Model model) {
        return "stats/expired-inventory";
    }
}

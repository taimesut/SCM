/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class StatsController {

    @Autowired
    private StatsService mainService;

    @GetMapping("/stats/1")
    public String currentInventoryView(Model model) {

        return "/stats/current-inventory";
    }

    @GetMapping("/stats/2")
    public String expiringInventoryView(Model model) {

        return "/stats/current-inventory";
    }

    @GetMapping("/stats/3")
    public String expiredInventoryView(Model model) {

        return "/stats/current-inventory";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.pojo.Inventory;
import com.mesut.services.InventoryService;
import com.mesut.services.ProductService;
import com.mesut.services.WarehouseService;
import com.mesut.utils.PrefixUrl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class InventoryController {

    // Đổi
    private static final String NAME = "inventory";

    // Không Đụng
    private static final String PREFIX_URL = PrefixUrl.PREFIX_URL;
    private static final String URL_BASE = PREFIX_URL + "/" + NAME;

    private static final String URL_LIST_VIEW = URL_BASE;
    private static final String URL_ADD_VIEW = URL_BASE + "/add";
    private static final String URL_ADD_PROCESS = URL_BASE + "/add";
    private static final String URL_UPDATE_VIEW = URL_BASE + "/{id}";
    private static final String URL_UPDATE_PROCESS = URL_BASE + "/update";
    private static final String URL_DELETE_PROCESS = URL_BASE + "/delete/{id}";

    private static final String RETURN_LIST_VIEW = "manage/" + NAME;

    private static final String REDIRECT_ADD_SUCCESS = "redirect:" + URL_BASE + "/add?addSuccess";
    private static final String REDIRECT_ADD_ERROR = "redirect:" + URL_BASE + "/add?addError";
    private static final String REDIRECT_UPDATE_SUCCESS = "redirect:" + URL_BASE + "/%d?updateSuccess";
    private static final String REDIRECT_UPDATE_ERROR = "redirect:" + URL_BASE + "/%d?updateError";
    private static final String REDIRECT_DELETE_SUCCESS = "redirect:" + URL_BASE + "?deleteSuccess";
    private static final String REDIRECT_DELETE_ERROR = "redirect:" + URL_BASE + "?deleteError";

    private static final String FORM = "forms/form-" + NAME;

//    Đổi Service
    @Autowired
    private InventoryService mainService;

    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping(URL_LIST_VIEW)
    public String listView(Model model) {
        model.addAttribute("list", this.mainService.getList());
        model.addAttribute("name", NAME);
        return RETURN_LIST_VIEW;
    }

   

    
}

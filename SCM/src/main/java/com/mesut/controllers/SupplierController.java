/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.pojo.Category;
import com.mesut.pojo.Supplier;
import com.mesut.services.CategoryService;
import com.mesut.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class SupplierController {

    
    // Đổi
    private static final String BASE = "suppliers";
    private static final String NAME = "supplier";

    // Không Đụng
    private static final String URL_LIST_VIEW = "/" + BASE;
    private static final String URL_ADD_VIEW = "/" + BASE + "/add";
    private static final String URL_ADD_PROCESS = "/" + BASE + "/add";
    private static final String URL_UPDATE_VIEW = "/" + BASE + "/{id}";
    private static final String URL_UPDATE_PROCESS = "/" + BASE + "/update";
    private static final String URL_DELETE_PROCESS = "/" + BASE + "/delete/{id}";

    private static final String RETURN_LIST_VIEW = BASE;

    private static final String REDIRECT_ADD_SUCCESS = "redirect:/" + BASE + "/add?addSuccess";
    private static final String REDIRECT_ADD_ERROR = "redirect:/" + BASE + "/add?addError";
    private static final String REDIRECT_UPDATE_SUCCESS = "redirect:/" + BASE + "/%d?updateSuccess";
    private static final String REDIRECT_UPDATE_ERROR = "redirect:/" + BASE + "/%d?updateError";
    private static final String REDIRECT_DELETE_SUCCESS = "redirect:/" + BASE + "?deleteSuccess";
    private static final String REDIRECT_DELETE_ERROR = "redirect:/" + BASE + "?deleteError";

    private static final String FORM = "forms/form-" + NAME;

    @Autowired
    private SupplierService mainService;

    @GetMapping(URL_LIST_VIEW)
    public String listView(Model model) {
        model.addAttribute("list", this.mainService.getList());
        return RETURN_LIST_VIEW;
    }

    @GetMapping(URL_ADD_VIEW)
    public String addView(Model model) {
        // Đổi class
        model.addAttribute("object", new Supplier());
        return FORM;
    }

    // Đổi class @ModelAttribute
    @PostMapping(URL_ADD_PROCESS)
    public String addProcess(@ModelAttribute(value = "object") Supplier o) {
        try {
            this.mainService.addOrUpdate(o);
            return REDIRECT_ADD_SUCCESS;
        } catch (Exception e) {
            return REDIRECT_ADD_ERROR;
        }
    }

    @GetMapping(URL_UPDATE_VIEW)
    public String updateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("object", this.mainService.getById(id));
        return FORM;
    }

    // Đổi class @ModelAttribute
    @PostMapping(URL_UPDATE_PROCESS)
    public String updateProcess(@ModelAttribute(value = "object") Supplier o) {
        try {
            this.mainService.addOrUpdate(o);
            return String.format(REDIRECT_UPDATE_SUCCESS, o.getId());
        } catch (Exception e) {
            return String.format(REDIRECT_UPDATE_ERROR, o.getId());
        }
    }

    @GetMapping(URL_DELETE_PROCESS)
    public String deleteProcess(@PathVariable(value = "id") int id) {
        try {
            this.mainService.deleteById(id);
            return REDIRECT_DELETE_SUCCESS;
        } catch (Exception e) {
            return REDIRECT_DELETE_ERROR;
        }
    }
}

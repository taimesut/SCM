/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mesut.pojo.Product;
import com.mesut.services.CategoryService;
import com.mesut.services.ProductService;
import com.mesut.services.SupplierService;
import com.mesut.services.impl.UserServiceImpl;
import com.mesut.utils.PrefixUrl;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class ProductController {
    // Đổi

    private static final String NAME = "product";

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
    private ProductService mainService;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SupplierService supplierService;

    @GetMapping(URL_LIST_VIEW)
    public String listView(Model model) {
        model.addAttribute("list", this.mainService.getList());
        model.addAttribute("name", NAME);
        return RETURN_LIST_VIEW;
    }

    @GetMapping(URL_ADD_VIEW)
    public String addView(Model model) {
        // Đổi class
        model.addAttribute("object", new Product());
        model.addAttribute("name", NAME);
        model.addAttribute("list_supplier", this.supplierService.getList());
        model.addAttribute("list_category", this.categoryService.getList());

        return FORM;
    }

    // Đổi class @ModelAttribute
    @PostMapping(URL_ADD_PROCESS)
    public String addProcess(@ModelAttribute(value = "object") Product o, @RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                try {
                    Map res = cloudinary.uploader().upload(file.getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    o.setImage(res.get("secure_url").toString());
                } catch (IOException ex) {
                    Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.mainService.addOrUpdate(o);
            return REDIRECT_ADD_SUCCESS;
        } catch (Exception e) {
            return REDIRECT_ADD_ERROR;
        }
    }

    @GetMapping(URL_UPDATE_VIEW)
    public String updateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("object", this.mainService.getById(id));
        model.addAttribute("name", NAME);
        model.addAttribute("list_supplier", this.supplierService.getList());
        model.addAttribute("list_category", this.categoryService.getList());
        return FORM;
    }

    // Đổi class @ModelAttribute
    @PostMapping(URL_UPDATE_PROCESS)
    public String updateProcess(@ModelAttribute(value = "object") Product o, @RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                try {
                    Map res = cloudinary.uploader().upload(file.getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    o.setImage(res.get("secure_url").toString());
                } catch (IOException ex) {
                    Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.mainService.addOrUpdate(o);
            return String.format(REDIRECT_UPDATE_SUCCESS, o.getId());
        } catch (Exception e) {
            return String.format(REDIRECT_UPDATE_ERROR, o.getId());
        }
    }

    @GetMapping(URL_DELETE_PROCESS)
    public String deleteProcess(@PathVariable(value = "id") int id
    ) {
        try {
            this.mainService.deleteById(id);
            return REDIRECT_DELETE_SUCCESS;
        } catch (Exception e) {
            return REDIRECT_DELETE_ERROR;
        }
    }
}

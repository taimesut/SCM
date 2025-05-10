/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.pojo.Category;
import com.mesut.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService cateService;

    @GetMapping("/categories")
    public String categoryView(Model model) {
        model.addAttribute("categories", this.cateService.getCategories());
        return "categories";
    }

    @GetMapping("/categories/add")
    public String addCategoryView(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/categories/add")
    public String addCategoryProcess(@ModelAttribute(value = "category") Category c) {
        try {
            this.cateService.addOrUpdateCategory(c);
            return "redirect:/categories/add?success";
        } catch (Exception e) {
            return "redirect:/categories/add?error";
        }
    }

    @GetMapping("/categories/{categoryId}")
    public String updateCategoryView(Model model, @PathVariable(value = "categoryId") int id) {
        model.addAttribute("category", this.cateService.getCategoryById(id));
        return "updateCategory";
    }

    @PostMapping("/categories/update")
    public String updateCategoryProcess(@ModelAttribute(value = "category") Category c) {
        try {
            this.cateService.addOrUpdateCategory(c);
            return "redirect:/categories/" + c.getId() + "?success";
        } catch (Exception e) {
            return "redirect:/categories/" + c.getId() + "?error";
        }
    }
    
    @GetMapping("/categories/delete/{categoryId}")
    public String updateCategoryProcess(@PathVariable(value = "categoryId") int id) {
        try {
            this.cateService.deleteCategoryById(id);
            return "redirect:/categories?success";
        } catch (Exception e) {
            return "redirect:/categories?error";
        }
    }
    
}

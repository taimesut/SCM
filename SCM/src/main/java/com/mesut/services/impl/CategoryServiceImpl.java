/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Category;
import com.mesut.repositories.CategoryRepository;
import com.mesut.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepo;
    
    @Override
    public List<Category> getCategories() {
        return this.categoryRepo.getCategories();
    }

    @Override
    public Category addOrUpdateCategory(Category c) {
        c.setCreateDate(new java.sql.Date(System.currentTimeMillis()));
        return this.categoryRepo.addOrUpdateCategory(c);
    }

    @Override
    public Category getCategoryById(int id) {
        return this.categoryRepo.getCategoryById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCategoryById(int id) {
        this.categoryRepo.deleteCategoryById(id);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Category;
import com.mesut.repositories.CategoryRepository;
import com.mesut.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 */
@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}

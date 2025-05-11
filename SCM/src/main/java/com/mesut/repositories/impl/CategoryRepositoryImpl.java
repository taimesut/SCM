/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Category;
import com.mesut.repositories.CategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author THANHTAIPC
 */
@Repository
@Transactional
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category> implements CategoryRepository {

    public CategoryRepositoryImpl() {
        super(Category.class);
    }
    
}

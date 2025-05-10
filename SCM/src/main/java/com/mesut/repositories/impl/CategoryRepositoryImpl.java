/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Category;
import com.mesut.repositories.CategoryRepository;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author THANHTAIPC
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public Category addOrUpdateCategory(Category c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() == null) {
            s.persist(c);
        } else {
            s.merge(c);
        }
        return c;
    }
    
    @Override
    public List<Category> getCategories() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }
    
    @Override
    public Category getCategoryById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Category.class, id);
    }
    
    @Override
    public void deleteCategoryById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Category c = this.getCategoryById(id);
        s.remove(c);
    }
    
}

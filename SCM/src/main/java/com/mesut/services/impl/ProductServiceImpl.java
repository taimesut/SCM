/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Product;
import com.mesut.repositories.ProductRepository;
import com.mesut.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository mainRepo;
    
    @Override
    public List<Product> getList() {
        return this.mainRepo.getList();
    }

    @Override
    public Product addOrUpdate(Product c) {
        return this.mainRepo.addOrUpdate(c);
    }

    @Override
    public Product getById(int id) {
        return this.mainRepo.getById(id);
    }

    @Override
    public void deleteById(int id) {
        this.mainRepo.deleteById(id);
    }
    
}

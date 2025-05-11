/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Product;
import com.mesut.repositories.ProductRepository;
import com.mesut.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }

    
    
}

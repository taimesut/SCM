/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mesut.pojo.Product;
import com.mesut.repositories.ProductRepository;
import com.mesut.services.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {
    
    @Autowired
    private Cloudinary cloudinary;
        @Autowired
    private ProductRepository prodRepo;
    @Override
    public Product addOrUpdate(Product c) {
//        if (!c.getFile().isEmpty()) {
//            try {
//                Map res = cloudinary.uploader().upload(c.getFile().getBytes(),
//                        ObjectUtils.asMap("resource_type", "auto"));
//                c.setImage(res.get("secure_url").toString());
//            } catch (IOException ex) {
//                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return super.addOrUpdate(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }

    
        @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.prodRepo.getProducts(params);
    
    }
}

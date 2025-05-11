/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.ReviewSupplier;
import com.mesut.repositories.ReviewSupplierRepository;
import com.mesut.services.ReviewSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewSupplierServiceImpl extends GenericServiceImpl<ReviewSupplier> implements ReviewSupplierService {

    @Autowired
    public ReviewSupplierServiceImpl(ReviewSupplierRepository repository) {
        super(repository);
    }

    
}

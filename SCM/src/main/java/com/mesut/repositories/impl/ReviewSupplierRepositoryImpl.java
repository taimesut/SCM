/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.ReviewSupplier;
import com.mesut.repositories.ReviewSupplierRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReviewSupplierRepositoryImpl extends GenericRepositoryImpl<ReviewSupplier> implements ReviewSupplierRepository {

    public ReviewSupplierRepositoryImpl() {
        super(ReviewSupplier.class);
    }

  
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.ReviewShipmentCompany;
import com.mesut.repositories.ReviewShipmentCompanyRepository;
import com.mesut.services.ReviewShipmentCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewShipmentCompanyServiceImpl extends GenericServiceImpl<ReviewShipmentCompany> implements ReviewShipmentCompanyService {

    @Autowired
    public ReviewShipmentCompanyServiceImpl(ReviewShipmentCompanyRepository repository) {
        super(repository);
    }

    
}

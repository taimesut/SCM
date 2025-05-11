/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.ShipmentCompanyContact;
import com.mesut.repositories.ShipmentCompanyContactRepository;
import com.mesut.services.ShipmentCompanyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentCompanyContactServiceImpl extends GenericServiceImpl<ShipmentCompanyContact> implements ShipmentCompanyContactService {
    @Autowired
    public ShipmentCompanyContactServiceImpl(ShipmentCompanyContactRepository repository) {
        super(repository);
    }

  
}

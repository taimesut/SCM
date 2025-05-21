/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.ShipmentCompany;
import com.mesut.repositories.ShipmentCompanyRepository;
import com.mesut.services.ShipmentCompanyService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentCompanyServiceImpl extends GenericServiceImpl<ShipmentCompany>implements ShipmentCompanyService {
    @Autowired
    public ShipmentCompanyServiceImpl(ShipmentCompanyRepository repository) {
        super(repository);
    }



    
}

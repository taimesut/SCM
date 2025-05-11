/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Shipment;
import com.mesut.repositories.ShipmentRepository;
import com.mesut.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl extends GenericServiceImpl<Shipment>implements ShipmentService {
    @Autowired
    public ShipmentServiceImpl(ShipmentRepository repository) {
        super(repository);
    }

   
    
}

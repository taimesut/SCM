/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Shipment;
import com.mesut.repositories.ShipmentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ShipmentRepositoryImpl extends GenericRepositoryImpl<Shipment> implements ShipmentRepository {

    public ShipmentRepositoryImpl() {
        super(Shipment.class);
    }

   
    
}

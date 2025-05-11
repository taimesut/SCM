/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.ShipmentCompanyContact;
import com.mesut.repositories.ShipmentCompanyContactRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ShipmentCompanyContactRepositoryImpl extends GenericRepositoryImpl<ShipmentCompanyContact> implements ShipmentCompanyContactRepository {

    public ShipmentCompanyContactRepositoryImpl() {
        super(ShipmentCompanyContact.class);
    }

   
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.ShipmentCompany;
import com.mesut.repositories.ShipmentCompanyRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ShipmentCompanyRepositoryImpl extends GenericRepositoryImpl<ShipmentCompany> implements ShipmentCompanyRepository {

    public ShipmentCompanyRepositoryImpl() {
        super(ShipmentCompany.class);
    }

    
}

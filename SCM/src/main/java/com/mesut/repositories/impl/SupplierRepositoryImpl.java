/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Supplier;
import com.mesut.repositories.SupplierRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author THANHTAIPC
 */
@Repository
@Transactional
public class SupplierRepositoryImpl extends GenericRepositoryImpl<Supplier> implements SupplierRepository {

    public SupplierRepositoryImpl() {
        super(Supplier.class);
    }

    

}

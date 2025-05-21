/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Supplier;
import com.mesut.repositories.SupplierRepository;
import com.mesut.services.SupplierService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 */
@Service
public class SupplierServiceImpl extends GenericServiceImpl<Supplier> implements SupplierService {

    @Autowired
    public SupplierServiceImpl(SupplierRepository repository) {
        super(repository);
    }


    

}

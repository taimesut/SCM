/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Warehouse;
import com.mesut.repositories.WarehouseRepository;
import com.mesut.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 */
@Service
public class WarehouseServiceImpl extends GenericServiceImpl<Warehouse> implements WarehouseService {
    
    @Autowired
    public WarehouseServiceImpl(WarehouseRepository repository) {
        super(repository);
    }
    
    
    
}

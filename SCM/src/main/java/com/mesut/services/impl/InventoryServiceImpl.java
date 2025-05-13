/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Inventory;
import com.mesut.repositories.InventoryRepository;
import com.mesut.services.InventoryService;
import com.mesut.utils.CreateDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl extends GenericServiceImpl<Inventory> implements InventoryService {

    @Override
    public Inventory addOrUpdate(Inventory c) {
        c.setUpdateDate(CreateDateUtils.createDate());
        return super.addOrUpdate(c);
    }

    @Autowired
    public InventoryServiceImpl(InventoryRepository repository) {
        super(repository);
    }

    
}

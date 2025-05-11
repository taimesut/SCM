/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Inventory;
import com.mesut.repositories.InventoryRepository;
import com.mesut.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl extends GenericServiceImpl<Inventory> implements InventoryService {

    @Autowired
    public InventoryServiceImpl(InventoryRepository repository) {
        super(repository);
    }

    
}

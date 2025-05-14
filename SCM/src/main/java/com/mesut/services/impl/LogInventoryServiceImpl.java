/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.LogInventory;
import com.mesut.repositories.LogInventoryRepository;
import com.mesut.services.LogInventoryService;
import com.mesut.utils.CreateDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInventoryServiceImpl extends GenericServiceImpl<LogInventory> implements LogInventoryService {

    @Autowired
    public LogInventoryServiceImpl(LogInventoryRepository repository) {
        super(repository);
    }

    @Override
    public LogInventory addOrUpdate(LogInventory c) {
        if (c.getId() == null) {
            c.setCreateDate(CreateDateUtils.createDate());
        }
        return super.addOrUpdate(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}

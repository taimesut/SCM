/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Warehouse;
import com.mesut.repositories.WarehouseRepository;
import com.mesut.services.WarehouseService;
import com.mesut.utils.CreateDateUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    
    @Autowired
    private WarehouseRepository mainRepo;
    
    @Override
    public List<Warehouse> getList() {
        return this.mainRepo.getList();
    }
    
    @Override
    public Warehouse addOrUpdate(Warehouse c) {
        return this.mainRepo.addOrUpdate(c);
    }
    
    @Override
    public Warehouse getById(int id) {
        return this.mainRepo.getById(id);
    }
    
    @Override
    public void deleteById(int id) {
        this.mainRepo.deleteById(id);
    }
    
}

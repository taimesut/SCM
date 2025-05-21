/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Inventory;
import com.mesut.pojo.Product;
import com.mesut.pojo.Warehouse;
import com.mesut.repositories.InventoryRepository;
import com.mesut.services.InventoryService;
import com.mesut.utils.CreateDateUtils;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl extends GenericServiceImpl<Inventory> implements InventoryService {

    @Autowired
    private InventoryRepository mainRepository;

    @Override
    public Inventory addOrUpdate(Inventory c) {

        c.setUpdateDate(CreateDateUtils.createDate());

        return super.addOrUpdate(c);
    }

    @Autowired
    public InventoryServiceImpl(InventoryRepository repository) {
        super(repository);
    }

    @Override
    public void updateAmount(int warehouse_id, int product_id, int amount_insert) {
        this.mainRepository.updateAmount(warehouse_id, product_id, amount_insert);
    }

    @Override
    public Inventory findByWarehouseIdAndProductId(Warehouse warehouse_id, Product product_id) {
        return this.mainRepository.findByWarehouseIdAndProductId(warehouse_id, product_id);
    }



}

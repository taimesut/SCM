/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.DetailReceiptImport;
import com.mesut.pojo.LogInventory;
import com.mesut.repositories.DetailReceiptImportRepository;
import com.mesut.services.DetailReceiptImportService;
import com.mesut.services.InventoryService;
import com.mesut.services.LogInventoryService;
import com.mesut.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DetailReceiptImportServiceImpl extends GenericServiceImpl<DetailReceiptImport> implements DetailReceiptImportService {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private LogInventoryService logInventoryService;

    
    @Override
    public DetailReceiptImport addOrUpdate(DetailReceiptImport c) {
        int warehouse_id = c.getReceiptImportId().getId();
        int amount = c.getAmount();
        int product_id = c.getProductId().getId();
        LogInventory log = new LogInventory();
        log.setReceiptImportId(c.getReceiptImportId());
        log.setPrice(c.getPrice());
        log.setAmount(c.getAmount());
        log.setProductId(c.getProductId());
        this.logInventoryService.addOrUpdate(log);
        
        this.logInventoryService.addOrUpdate(log);
        this.inventoryService.updateAmount(warehouse_id, product_id, amount);
        return super.addOrUpdate(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Autowired
    public DetailReceiptImportServiceImpl(DetailReceiptImportRepository repository) {
        super(repository);
    }

  
    
}

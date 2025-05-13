/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.DetailReceiptExport;
import com.mesut.repositories.DetailReceiptExportRepository;
import com.mesut.services.DetailReceiptExportService;
import com.mesut.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DetailReceiptExportServiceImpl extends GenericServiceImpl<DetailReceiptExport> implements DetailReceiptExportService {
    @Autowired
    private InventoryService inventoryService;
    
    @Override
    public DetailReceiptExport addOrUpdate(DetailReceiptExport c) {
        int warehouse_id = c.getReceiptExportId().getId();
        int amount = c.getAmount();
        int product_id = c.getProductId().getId();
        this.inventoryService.updateAmount(warehouse_id, product_id, -amount);
        return super.addOrUpdate(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Autowired
    public DetailReceiptExportServiceImpl(DetailReceiptExportRepository repository) {
        super(repository);
    }

    
}

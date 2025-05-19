/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.DetailReceiptExport;
import com.mesut.pojo.LogInventory;
import com.mesut.repositories.DetailReceiptExportRepository;
import com.mesut.services.DetailReceiptExportService;
import com.mesut.services.InventoryService;
import com.mesut.services.LogInventoryService;
import com.mesut.services.ReceiptExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DetailReceiptExportServiceImpl extends GenericServiceImpl<DetailReceiptExport> implements DetailReceiptExportService {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private LogInventoryService logInventoryService;

    @Autowired
    private ReceiptExportService receiptExportService;
    @Override
    public DetailReceiptExport addOrUpdate(DetailReceiptExport c) {
        int warehouse_id = this.receiptExportService.getById(c.getReceiptExportId().getId()).getWarehouseId().getId();
        int amount = c.getAmount();
        int product_id = c.getProductId().getId();
        LogInventory log = new LogInventory();
        log.setReceiptExportId(c.getReceiptExportId());
        log.setPrice(c.getPrice());
        log.setAmount(c.getAmount());
        log.setProductId(c.getProductId());
        this.inventoryService.updateAmount(warehouse_id, product_id, -amount);
        this.logInventoryService.addOrUpdate(log);

        return super.addOrUpdate(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Autowired
    public DetailReceiptExportServiceImpl(DetailReceiptExportRepository repository) {
        super(repository);
    }

}

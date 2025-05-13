/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.ReceiptExport;
import com.mesut.repositories.ReceiptExportRepository;
import com.mesut.services.ReceiptExportService;
import com.mesut.utils.CreateDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReceiptExportServiceImpl extends GenericServiceImpl<ReceiptExport>implements ReceiptExportService {

    @Autowired
    public ReceiptExportServiceImpl(ReceiptExportRepository repository) {
        super(repository);
    }
    @Override
    public ReceiptExport addOrUpdate(ReceiptExport c) {
        if(c.getCreateDate()==null)
            c.setCreateDate(CreateDateUtils.createDate());
        
        
        return super.addOrUpdate(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.InvoiceExport;
import com.mesut.repositories.GenericRepository;
import com.mesut.repositories.InvoiceExportRepository;
import com.mesut.services.InvoiceExportService;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceExportServiceImpl extends GenericServiceImpl<InvoiceExport> implements InvoiceExportService {
    
    @Autowired
    private InvoiceExportRepository ieRepo;
    
    @Autowired
    public InvoiceExportServiceImpl(InvoiceExportRepository repository) {
        super(repository);
    }

    @Override
    public InvoiceExport getInvoiceExportByOrderCode(String orderCode) {
        return this.ieRepo.getInvoiceExportByOrderCode(orderCode);
    }

    @Override
    public InvoiceExport updateInvoice(Map<String, String> params, Principal principal) {
        return this.ieRepo.updateInvoice(params);
    }

    
}

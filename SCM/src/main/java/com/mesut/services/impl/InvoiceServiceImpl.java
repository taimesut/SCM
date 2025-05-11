/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Invoice;
import com.mesut.repositories.InvoiceRepository;
import com.mesut.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl extends GenericServiceImpl<Invoice> implements InvoiceService {
    @Autowired
    public InvoiceServiceImpl(InvoiceRepository repository) {
        super(repository);
    }

    
}

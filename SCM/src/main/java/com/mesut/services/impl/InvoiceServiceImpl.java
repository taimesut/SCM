/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Invoice;
import com.mesut.repositories.GenericRepository;
import com.mesut.repositories.InvoiceRepository;
import com.mesut.services.InvoiceService;
import java.util.List;


public class InvoiceServiceImpl extends GenericServiceImpl<Invoice> implements InvoiceService {

    public InvoiceServiceImpl(InvoiceRepository repository) {
        super(repository);
    }

    
    
}

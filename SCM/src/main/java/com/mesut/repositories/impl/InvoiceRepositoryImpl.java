/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Invoice;
import com.mesut.repositories.InvoiceRepository;
import java.util.List;


public class InvoiceRepositoryImpl extends GenericRepositoryImpl<Invoice> implements InvoiceRepository {

    public InvoiceRepositoryImpl() {
        super(Invoice.class);
    }

   
}

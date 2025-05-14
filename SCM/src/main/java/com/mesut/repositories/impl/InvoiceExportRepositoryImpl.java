/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.InvoiceExport;
import com.mesut.repositories.InvoiceExportRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class InvoiceExportRepositoryImpl extends GenericRepositoryImpl<InvoiceExport>implements InvoiceExportRepository {

    public InvoiceExportRepositoryImpl() {
        super(InvoiceExport.class);
    }

  
    
}

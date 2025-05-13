/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.ReceiptExport;
import com.mesut.repositories.ReceiptExportRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReceiptExportRepositoryImpl  extends GenericRepositoryImpl<ReceiptExport> implements ReceiptExportRepository {

    public ReceiptExportRepositoryImpl() {
        super(ReceiptExport.class);
    }

   
    
}

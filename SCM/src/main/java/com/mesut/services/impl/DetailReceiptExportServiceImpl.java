/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.DetailReceiptExport;
import com.mesut.repositories.DetailReceiptExportRepository;
import com.mesut.services.DetailReceiptExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DetailReceiptExportServiceImpl extends GenericServiceImpl<DetailReceiptExport> implements DetailReceiptExportService {

    @Autowired
    public DetailReceiptExportServiceImpl(DetailReceiptExportRepository repository) {
        super(repository);
    }

    
}

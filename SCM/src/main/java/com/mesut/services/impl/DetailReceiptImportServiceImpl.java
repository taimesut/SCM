/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.DetailReceiptImport;
import com.mesut.repositories.DetailReceiptImportRepository;
import com.mesut.repositories.GenericRepository;
import com.mesut.services.DetailReceiptImportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DetailReceiptImportServiceImpl extends GenericServiceImpl<DetailReceiptImport> implements DetailReceiptImportService {

    @Autowired
    public DetailReceiptImportServiceImpl(DetailReceiptImportRepository repository) {
        super(repository);
    }

  
    
}

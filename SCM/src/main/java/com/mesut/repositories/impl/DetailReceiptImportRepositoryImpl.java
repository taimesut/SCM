/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.DetailReceiptImport;
import com.mesut.repositories.DetailReceiptImportRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DetailReceiptImportRepositoryImpl extends GenericRepositoryImpl<DetailReceiptImport> implements DetailReceiptImportRepository {

    public DetailReceiptImportRepositoryImpl() {
        super(DetailReceiptImport.class);
    }

    
    
}

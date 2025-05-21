/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.DetailReceiptExport;
import com.mesut.repositories.DetailReceiptExportRepository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DetailReceiptExportRepositoryImpl extends GenericRepositoryImpl<DetailReceiptExport> implements DetailReceiptExportRepository {

    public DetailReceiptExportRepositoryImpl() {
        super(DetailReceiptExport.class);
    }

    @Override
    public List<DetailReceiptExport> getAllWithFilter(Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countWithFilter(Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    
    
}

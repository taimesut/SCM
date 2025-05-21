/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.ReceiptImport;
import com.mesut.repositories.ReceiptImportRepository;
import com.mesut.services.ReceiptImportService;
import com.mesut.services.UserService;
import com.mesut.utils.CreateDateUtils;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReceiptImportServiceImpl extends GenericServiceImpl<ReceiptImport> implements ReceiptImportService {

    @Autowired
    public ReceiptImportServiceImpl(ReceiptImportRepository repository) {
        super(repository);
    }

    @Override
    public ReceiptImport addOrUpdate(ReceiptImport c) {
        if (c.getId() == null) {
            c.setCreateDate(CreateDateUtils.createDate());
        }
        return super.addOrUpdate(c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}

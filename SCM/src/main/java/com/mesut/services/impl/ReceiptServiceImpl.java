/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Receipt;
import com.mesut.repositories.ReceiptRepository;
import com.mesut.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl extends GenericServiceImpl<Receipt> implements ReceiptService {

    @Autowired
    public ReceiptServiceImpl(ReceiptRepository repository) {
        super(repository);
    }

    
    
}

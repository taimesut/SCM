/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.DetailReceipt;
import com.mesut.repositories.DetailReceiptRepository;
import com.mesut.services.DetailReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailReceiptServiceImpl extends GenericServiceImpl<DetailReceipt> implements DetailReceiptService {

    @Autowired
    public DetailReceiptServiceImpl(DetailReceiptRepository repository) {
        super(repository);
    }

    
}

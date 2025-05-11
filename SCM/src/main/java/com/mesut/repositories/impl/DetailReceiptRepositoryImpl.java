/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.DetailReceipt;
import com.mesut.repositories.DetailReceiptRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DetailReceiptRepositoryImpl extends GenericRepositoryImpl<DetailReceipt> implements DetailReceiptRepository {

    public DetailReceiptRepositoryImpl() {
        super(DetailReceipt.class);
    }

   
    
}

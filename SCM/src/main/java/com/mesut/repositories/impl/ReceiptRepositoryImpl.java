/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Receipt;
import com.mesut.repositories.ReceiptRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReceiptRepositoryImpl extends GenericRepositoryImpl<Receipt> implements ReceiptRepository {

    public ReceiptRepositoryImpl() {
        super(Receipt.class);
    }

}

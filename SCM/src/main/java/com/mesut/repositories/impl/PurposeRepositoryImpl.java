/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Purpose;
import com.mesut.repositories.PurposeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author THANHTAIPC
 */
@Repository
@Transactional
public class PurposeRepositoryImpl extends GenericRepositoryImpl<Purpose> implements PurposeRepository {

    public PurposeRepositoryImpl() {
        super(Purpose.class);
    }

   

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Purpose;
import com.mesut.repositories.PurposeRepository;
import com.mesut.services.PurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 */
@Service
public class PurposeServiceImpl extends GenericServiceImpl<Purpose> implements PurposeService {
    @Autowired
    public PurposeServiceImpl(PurposeRepository repository) {
        super(repository);
    }
    
   
}

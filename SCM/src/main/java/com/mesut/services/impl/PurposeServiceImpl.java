/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Category;
import com.mesut.pojo.Purpose;
import com.mesut.repositories.PurposeRepository;
import com.mesut.services.PurposeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 */
@Service
public class PurposeServiceImpl implements PurposeService {
    
    @Autowired
    private PurposeRepository mainRepo;
    
    @Override
    public List<Purpose> getList() {
        return this.mainRepo.getList();
    }
    
    @Override
    public Purpose addOrUpdate(Purpose c) {
        return this.mainRepo.addOrUpdate(c);
    }
    
    @Override
    public Purpose getById(int id) {
        return this.mainRepo.getById(id);
    }
    
    @Override
    public void deleteById(int id) {
        this.mainRepo.deleteById(id);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.repositories.StatsRepository;
import com.mesut.services.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository mainRepository;
    
    @Override
    public List<Object[]> currentInventory() {
        return this.mainRepository.currentInventory();
    }

    @Override
    public List<Object[]> expiringInventory(int days) {
        return this.mainRepository.expiringInventory(days);
    }

    @Override
    public List<Object[]> expiredInventory() {
        return this.mainRepository.expiredInventory();
    }
    
}

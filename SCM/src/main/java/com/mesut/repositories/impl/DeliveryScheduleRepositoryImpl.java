/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.DeliverySchedule;
import com.mesut.repositories.DeliveryScheduleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DeliveryScheduleRepositoryImpl extends GenericRepositoryImpl<DeliverySchedule> implements DeliveryScheduleRepository {

    public DeliveryScheduleRepositoryImpl() {
        super(DeliverySchedule.class);
    }

  
    
}

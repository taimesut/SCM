/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.DeliverySchedule;
import com.mesut.repositories.DeliveryScheduleRepository;
import com.mesut.services.DeliveryScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryScheduleServiceImpl extends GenericServiceImpl<DeliverySchedule> implements DeliveryScheduleService {

    @Autowired
    public DeliveryScheduleServiceImpl(DeliveryScheduleRepository repository) {
        super(repository);
    }

   
}

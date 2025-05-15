/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.apis;

import com.mesut.pojo.Warehouse;
import com.mesut.services.GenericService;
import com.mesut.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author THANHTAIPC
 */
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseApi extends GenericApi<Warehouse>{
    
    @Autowired
    public WarehouseApi(WarehouseService service) {
        super(service);
    }
    
}

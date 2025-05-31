/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.apis;

import com.mesut.services.ReviewShipmentCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TAN TAI
 */
@RestController
@RequestMapping("/api/review-shipment-company")
public class ReviewShipmentCompany extends GenericApi<com.mesut.pojo.ReviewShipmentCompany>{
    @Autowired
    public ReviewShipmentCompany(ReviewShipmentCompanyService service) {
        super(service);
    }
}

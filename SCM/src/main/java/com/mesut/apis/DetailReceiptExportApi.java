package com.mesut.apis;

import com.mesut.pojo.DetailReceiptExport;
import com.mesut.services.DetailReceiptExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TAN TAI
 */
@RestController
@RequestMapping("/api/detail-receipt-export")
public class DetailReceiptExportApi extends GenericApi<DetailReceiptExport> {

    @Autowired
    public DetailReceiptExportApi(DetailReceiptExportService service) {
        super(service);
    }

}

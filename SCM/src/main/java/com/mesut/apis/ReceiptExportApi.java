/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.apis;

import com.mesut.pojo.ReceiptExport;
import com.mesut.services.ReceiptExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TAN TAI
 */
@RestController
@RequestMapping("/api/receipt-export")
public class ReceiptExportApi extends GenericApi<ReceiptExport> {

    @Autowired
    public ReceiptExportApi(ReceiptExportService service) {
        super(service);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<?> cancelReceiptExport(@PathVariable("id") int id) {
        ReceiptExport re = this.mainService.getById(id);
        if (re == null) {
            return ResponseEntity.notFound().build();
        }
        re.setStatus("cancelled");
        return ResponseEntity.ok(this.mainService.addOrUpdate(re));
    }

}

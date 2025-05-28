/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.apis;

import com.mesut.pojo.ReceiptExport;
import com.mesut.pojo.User;
import com.mesut.services.ReceiptExportService;
import com.mesut.services.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author TAN TAI
 */
@RestController
@RequestMapping("/api/secure/receipt-export")
public class ReceiptExportApi extends GenericApi<ReceiptExport> {

    private final ReceiptExportService reService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    public ReceiptExportApi(ReceiptExportService service) {
        super(service);
        this.reService = service;
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

    @GetMapping("/user-receipt")
    public ResponseEntity<?> getUserOrders(Principal principal) {
        User u = this.userService.getUserByUsername(principal.getName());
        if (u != null)
            return ResponseEntity.ok(this.reService.getReceiptExportsByUserId(u.getId()));
        else
            return ResponseEntity.status(400).build();
    }


}

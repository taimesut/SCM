/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.services;

import com.mesut.pojo.InvoiceExport;

import java.security.Principal;
import java.util.Map;

/**
 *
 * @author THANHTAIPC
 */
public interface InvoiceExportService extends GenericService<InvoiceExport>{
    InvoiceExport getInvoiceExportByOrderCode(String orderCode);
    InvoiceExport updateInvoice(Map<String, String> params, Principal principal);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import com.mesut.pojo.InvoiceExport;

import java.util.Map;

/** //User getUserByUsername(String username);
 *
 * @author THANHTAIPC
 */
public interface InvoiceExportRepository extends GenericRepository<InvoiceExport>{
    InvoiceExport getInvoiceExportByOrderCode(String orderCode);
    InvoiceExport updateInvoice(Map<String, String> params);
}

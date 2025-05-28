/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.services;

import com.mesut.pojo.ReceiptExport;
import java.util.List;

/**
 *
 * @author THANHTAIPC
 */
public interface ReceiptExportService extends GenericService<ReceiptExport>{
    List<ReceiptExport> getReceiptExportsByUserId(int id);
}

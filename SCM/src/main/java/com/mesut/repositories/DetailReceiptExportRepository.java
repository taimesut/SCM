/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import com.mesut.pojo.DetailReceiptExport;

import java.util.List;

/**
 *
 * @author THANHTAIPC
 */
public interface DetailReceiptExportRepository extends GenericRepository<DetailReceiptExport>{
    List<DetailReceiptExport>getDetailReceiptExportsByUserId(int id);
}

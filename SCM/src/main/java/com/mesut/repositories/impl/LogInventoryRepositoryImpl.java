/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.LogInventory;
import com.mesut.repositories.LogInventoryRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LogInventoryRepositoryImpl extends GenericRepositoryImpl<LogInventory> implements LogInventoryRepository {

    public LogInventoryRepositoryImpl() {
        super(LogInventory.class);
    }

    @Override
    public List<Predicate> doFilter(Map<String, String> params, CriteriaBuilder b, Root<LogInventory> root) {
        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(root.get("receiptImportId").get("id").as(String.class), "%" + kw + "%"));
        }
        String kw2 = params.get("kw2");
        if (kw2 != null && !kw2.isEmpty()) {
            predicates.add(b.like(root.get("receiptExportId").get("id").as(String.class), "%" + kw2 + "%"));
        }
        String kw3 = params.get("kw3");
        if (kw3 != null && !kw3.isEmpty()) {
            predicates.add(b.like(root.get("receiptImportId").get("warehouseId").get("name").as(String.class), "%" + kw3 + "%"));
        }
        String kw4 = params.get("kw4");
        if (kw4 != null && !kw4.isEmpty()) {
            predicates.add(b.like(root.get("receiptExportId").get("warehouseId").get("name").as(String.class), "%" + kw4 + "%"));
        }
        String kw5 = params.get("kw5");
        
        if (kw5 != null && !kw5.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = sdf.parse(kw5);
                predicates.add(b.equal(root.get("createDate"), date));
            } catch (ParseException ex) {
                Logger.getLogger(InvoiceExportRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return predicates;
    }

}

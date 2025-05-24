/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.InvoiceExport;
import com.mesut.repositories.InvoiceExportRepository;
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

@Transactional
@Repository
public class InvoiceExportRepositoryImpl extends GenericRepositoryImpl<InvoiceExport> implements InvoiceExportRepository {

    public InvoiceExportRepositoryImpl() {
        super(InvoiceExport.class);
    }

    @Override
    public List<Predicate> doFilter(Map<String, String> params, CriteriaBuilder b, Root<InvoiceExport> root) {
        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            System.out.println(kw);
            predicates.add(b.like(root.get("receiptExportId").get("id").as(String.class), "%" + kw + "%"));
        }
        String kw2 = params.get("kw2");
        if (kw2 != null && !kw2.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = sdf.parse(kw2);
                predicates.add(b.equal(root.get("paymentDate"), date));
            } catch (ParseException ex) {
                Logger.getLogger(InvoiceExportRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return predicates;
    }

}

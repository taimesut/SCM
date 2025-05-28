/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.ReceiptExport;
import com.mesut.repositories.ReceiptExportRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReceiptExportRepositoryImpl extends GenericRepositoryImpl<ReceiptExport> implements ReceiptExportRepository {

    public ReceiptExportRepositoryImpl() {
        super(ReceiptExport.class);
    }

    @Override
    public List<Predicate> doFilter(Map<String, String> params, CriteriaBuilder b, Root<ReceiptExport> root) {
        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(root.get("id").as(String.class), "%" + kw + "%"));
        }
        String kw2 = params.get("kw2");
        if (kw2 != null && !kw2.isEmpty()) {
            predicates.add(b.like(root.get("customerId").get("name").as(String.class), "%" + kw2 + "%"));
        }
        String kw3 = params.get("kw3");
        if (kw3 != null && !kw3.isEmpty()) {
            predicates.add(b.like(root.get("creatorId").get("name").as(String.class), "%" + kw3 + "%"));
        }
        String kw4 = params.get("kw4");
        if (kw4 != null && !kw4.isEmpty()) {
            predicates.add(b.like(root.get("warehouseId").get("name").as(String.class), "%" + kw4 + "%"));
        }
        return predicates;
    }

    @Override
    public List<ReceiptExport> getReceiptExportsByUserId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("ReceiptExport.findByCustomerId", ReceiptExport.class);
        q.setParameter("customerId", id);
        List<ReceiptExport> results = q.getResultList();

        return results;
    }


}

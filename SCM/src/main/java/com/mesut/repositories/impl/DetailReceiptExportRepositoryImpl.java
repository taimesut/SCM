/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.constants.RepositoryConstants;
import com.mesut.pojo.Category;
import com.mesut.pojo.DetailReceiptExport;
import com.mesut.repositories.DetailReceiptExportRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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
public class DetailReceiptExportRepositoryImpl extends GenericRepositoryImpl<DetailReceiptExport> implements DetailReceiptExportRepository {

    public DetailReceiptExportRepositoryImpl() {
        super(DetailReceiptExport.class);
    }

    @Override
    public List<Predicate> doFilter(Map<String, String> params, CriteriaBuilder b, Root<DetailReceiptExport> root) {
        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(root.get("receiptExportId").get("id").as(String.class), "%" + kw + "%"));
        }
        String kw2 = params.get("kw2");
        if (kw2 != null && !kw2.isEmpty()) {
            predicates.add(b.like(root.get("productId").get("name").as(String.class), "%" + kw2 + "%"));
        }
        return predicates;
    }

}

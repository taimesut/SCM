/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.ReviewShipmentCompany;
import com.mesut.repositories.ReviewShipmentCompanyRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReviewShipmentCompanyRepositoryImpl extends GenericRepositoryImpl<ReviewShipmentCompany> implements ReviewShipmentCompanyRepository {

    public ReviewShipmentCompanyRepositoryImpl() {
        super(ReviewShipmentCompany.class);
    }

    @Override
    public List<Predicate> doFilter(Map<String, String> params, CriteriaBuilder b, Root<ReviewShipmentCompany> root) {
        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(root.get("id").as(String.class), "%" + kw + "%"));
        }
        String kw2 = params.get("kw2");
        if (kw2 != null && !kw2.isEmpty()) {
            predicates.add(b.like(root.get("shipmentId").get("shipmentCompanyId").get("name").as(String.class), "%" + kw2 + "%"));
        }
        return predicates;
    }

}

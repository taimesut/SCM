/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.ShipmentCompanyContact;
import com.mesut.repositories.ShipmentCompanyContactRepository;
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
public class ShipmentCompanyContactRepositoryImpl extends GenericRepositoryImpl<ShipmentCompanyContact> implements ShipmentCompanyContactRepository {

    public ShipmentCompanyContactRepositoryImpl() {
        super(ShipmentCompanyContact.class);
    }

    @Override
    public List<Predicate> doFilter(Map<String, String> params, CriteriaBuilder b, Root<ShipmentCompanyContact> root) {
        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(root.get("shipmentCompanyId").get("name").as(String.class), "%" + kw + "%"));
        }

        return predicates;
    }

}

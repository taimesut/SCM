/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.constants.RepositoryConstants;
import com.mesut.pojo.Category;
import com.mesut.pojo.Product;
import com.mesut.repositories.CategoryRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author THANHTAIPC
 */
@Repository
@Transactional
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category> implements CategoryRepository {

    public CategoryRepositoryImpl() {
        super(Category.class);
    }

    @Override
    public List<Predicate> doFilter(Map<String, String> params, CriteriaBuilder b, Root<Category> root) {
        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(root.get("name"), "%" + kw + "%"));
        }
        
        return predicates;
    }

//    @Override
//    public List<Category> getAllWithFilter(Map<String, String> params) {
//        Session s = this.factory.getObject().getCurrentSession();
//        CriteriaBuilder b = s.getCriteriaBuilder();
//        

////        Thay đổi class
//        CriteriaQuery<Category> q = b.createQuery(Category.class);
//        Root<Category> root = q.from(Category.class);
//        
//        
//        q.select(root);
//
////        Đổi điều kiện lọc
//        if (params != null) {
//            List<Predicate> predicates = new ArrayList<>();
//
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                predicates.add(b.like(root.get("name"), "%" + kw + "%"));
//            }
//
//            if (!predicates.isEmpty()) {
//                q.where(predicates.toArray(Predicate[]::new));
//            }
//        }
//
////        Sắp xếp
//        q.orderBy(b.asc(root.get("id")));
//
//        Query query = s.createQuery(q);
//
//        int page = 1;
//        if (params != null && params.get("page") != null) {
//            try {
//                page = Integer.parseInt(params.get("page"));
//            } catch (NumberFormatException ex) {
//                page = 1;
//            }
//        }
//
//        int start = (page - 1) * RepositoryConstants.DEFAULT_PAGE_SIZE;
//        query.setFirstResult(start);
//        query.setMaxResults(RepositoryConstants.DEFAULT_PAGE_SIZE);
//
//        return query.getResultList();
//    }
//
//    @Override
//    public int countWithFilter(Map<String, String> params) {
//        Session s = this.factory.getObject().getCurrentSession();
//        CriteriaBuilder b = s.getCriteriaBuilder();
//        CriteriaQuery<Long> q = b.createQuery(Long.class);
//        
////        Đổi class
//        Root<Category> root = q.from(Category.class);
//        q.select(b.count(root));
//
//        List<Predicate> predicates = new ArrayList<>();
//
////        Đổi điều kiện lọc
//        if (params != null) {
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                predicates.add(b.like(root.get("name"), "%" + kw + "%"));
//            }
//        }
//
//        if (!predicates.isEmpty()) {
//            q.where(predicates.toArray(Predicate[]::new));
//        }
//
//        return s.createQuery(q).getSingleResult().intValue();
//    }
    

}

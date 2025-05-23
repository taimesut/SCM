/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.constants.RepositoryConstants;
import com.mesut.pojo.Category;
import com.mesut.repositories.GenericRepository;
import com.mesut.pojo.Identifiable;
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
 * @param <T>
 */
@Repository
@Transactional
public abstract class GenericRepositoryImpl<T extends Identifiable> implements GenericRepository<T> {

    @Autowired
    protected LocalSessionFactoryBean factory;

    private final Class<T> entityClass;

    protected GenericRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T addOrUpdate(T c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() == null) {
            s.persist(c);
        } else {
            s.merge(c);
        }
        return c;
    }

    @Override
    public List<T> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM " + entityClass.getSimpleName(), entityClass);
        return query.getResultList();
    }

    @Override
    public T getById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(entityClass, id);
    }

    @Override
    public void deleteById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        T c = this.getById(id);
        if (c != null) {
            s.remove(c);
        }
    }

    @Override
    public List<T> getAllWithFilter(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();

        CriteriaQuery<T> q = b.createQuery(entityClass);
        Root<T> root = q.from(entityClass);

        q.select(root);

        List<Predicate> predicates = doFilter(params, b, root);
        if (!predicates.isEmpty()) {
            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.asc(root.get("id")));

        Query query = s.createQuery(q);

        int page = 1;
        if (params != null && params.get("page") != null) {
            try {
                page = Integer.parseInt(params.get("page"));
            } catch (NumberFormatException ex) {
                page = 1;
            }
        }

        int start = (page - 1) * RepositoryConstants.DEFAULT_PAGE_SIZE;
        query.setFirstResult(start);
        query.setMaxResults(RepositoryConstants.DEFAULT_PAGE_SIZE);

        return query.getResultList();
    }

    @Override
    public int countWithFilter(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Long> q = b.createQuery(Long.class);

        Root<T> root = q.from(entityClass);
        q.select(b.count(root));

        List<Predicate> predicates = doFilter(params, b, root);
        if (!predicates.isEmpty()) {
            q.where(predicates.toArray(Predicate[]::new));
        }

        return s.createQuery(q).getSingleResult().intValue();
    }

}

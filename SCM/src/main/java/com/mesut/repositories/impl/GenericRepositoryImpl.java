/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.repositories.GenericRepository;
import com.mesut.pojo.Identifiable;
import jakarta.persistence.Query;
import java.util.List;
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
    private LocalSessionFactoryBean factory;

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

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Category;
import com.mesut.pojo.Supplier;
import com.mesut.repositories.SupplierRepository;
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
 */
@Repository
@Transactional
public class SupplierRepositoryImpl implements SupplierRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Supplier addOrUpdate(Supplier c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() == null) {
            s.persist(c);
        } else {
            s.merge(c);
        }
        return c;
    }

    @Override
    public List<Supplier> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Supplier", Supplier.class);
        return query.getResultList();
    }

    @Override
    public Supplier getById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Supplier.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Supplier c = this.getById(id);
        s.remove(c);
    }

}

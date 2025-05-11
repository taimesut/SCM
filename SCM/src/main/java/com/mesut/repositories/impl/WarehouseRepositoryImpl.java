/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Warehouse;
import com.mesut.repositories.WarehouseRepository;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class WarehouseRepositoryImpl implements WarehouseRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Warehouse addOrUpdate(Warehouse c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() == null) {
            s.persist(c);
        } else {
            s.merge(c);
        }
        return c;
    }

    @Override
    public List<Warehouse> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Warehouse", Warehouse.class);
        return query.getResultList();
    }

    @Override
    public Warehouse getById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Warehouse.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Warehouse c = this.getById(id);
        s.remove(c);
    }

}

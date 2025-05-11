/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Category;
import com.mesut.pojo.Purpose;
import com.mesut.repositories.PurposeRepository;
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
public class PurposeRepositoryImpl implements PurposeRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Purpose addOrUpdate(Purpose c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() == null) {
            s.persist(c);
        } else {
            s.merge(c);
        }
        return c;
    }

    @Override
    public List<Purpose> getList() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Purpose", Purpose.class);
        return query.getResultList();
    }

    @Override
    public Purpose getById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Purpose.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Purpose c = this.getById(id);
        s.remove(c);
    }

}

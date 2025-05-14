/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import java.util.List;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mesut.repositories.StatsRepository;

@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> currentInventory() {
        Session session = factory.getObject().getCurrentSession();

        String hql = """
            SELECT i.id, p.name, w.name, i.amount, i.useDate, i.updateDate
            FROM Inventory i
            JOIN i.product p
            JOIN i.warehouse w
            ORDER BY i.amount ASC
        """;

        Query query = session.createQuery(hql, Object.class);
        return query.getResultList();
    }

    @Override
    public List<Object[]> expiringInventory(int days) {
        Session session = factory.getObject().getCurrentSession();

        String hql = """
            SELECT i.id, p.name, w.name, i.amount, i.useDate, i.updateDate
            FROM Inventory i
            JOIN i.product p
            JOIN i.warehouse w
            WHERE i.useDate IS NOT NULL AND DATEDIFF(i.useDate, CURRENT_DATE) BETWEEN 0 AND :days
            ORDER BY i.useDate ASC
        """;

        Query query = session.createQuery(hql, Object.class);
        query.setParameter("days", days);
        return query.getResultList();
    }

    @Override
    public List<Object[]> expiredInventory() {
        Session session = factory.getObject().getCurrentSession();

        String hql = """
            SELECT i.id, p.name, w.name, i.amount, i.useDate, i.updateDate
            FROM Inventory i
            JOIN i.product p
            JOIN i.warehouse w
            WHERE i.useDate IS NOT NULL AND i.useDate < CURRENT_DATE
            ORDER BY i.useDate ASC
        """;

        Query query = session.createQuery(hql, Object.class);
        return query.getResultList();
    }

}

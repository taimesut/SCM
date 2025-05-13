/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.User;
import org.springframework.transaction.annotation.Transactional;
import com.mesut.repositories.UserRepository;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author THANHTAIPC
 */
@Repository
@Transactional
public class UserRepositoryImpl extends GenericRepositoryImpl<User> implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername", User.class);
        q.setParameter("username", username);
        List<User> results = q.getResultList();
        
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public User addUser(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        s.persist(u);

        return u;
    }

    @Override
    public boolean authenticate(String username, String password) {
        User u = this.getUserByUsername(username);

        return this.passwordEncoder.matches(password, u.getPassword());
    }

}

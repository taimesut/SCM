/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import com.mesut.pojo.User;

/**
 *
 * @author THANHTAIPC
 */
public interface UserRepository extends GenericRepository<User>{
    User getUserByUsername(String username);
    User addUser(User u);
    boolean authenticate(String username, String password);
}

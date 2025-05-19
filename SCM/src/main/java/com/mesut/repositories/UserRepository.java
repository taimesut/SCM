/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import com.mesut.pojo.User;
import java.security.Principal;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author THANHTAIPC
 */
public interface UserRepository extends GenericRepository<User>{
    User getUserByUsername(String username);
    User addUser(User u);
    boolean authenticate(String username, String password);
    User updateUser(Map<String, String> params, Principal principal);
}

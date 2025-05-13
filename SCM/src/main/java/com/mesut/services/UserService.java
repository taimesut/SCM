/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.services;

import com.mesut.pojo.User;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author THANHTAIPC
 */
public interface UserService extends UserDetailsService, GenericService<User> {
    User getUserByUsername(String username);
    User addUser(Map<String, String> params, MultipartFile avatar);
    boolean authenticate(String username, String password);
    String getCurrentUsername();
}

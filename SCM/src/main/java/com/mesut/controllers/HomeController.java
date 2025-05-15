/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.pojo.User;
import com.mesut.services.UserService;
import jakarta.servlet.http.HttpSession;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loginView(HttpSession session, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.getUserByUsername(username);
            session.setAttribute("currentUser", user);
        }

        return "index";
    }
}

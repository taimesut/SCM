/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.controllers;

import com.mesut.pojo.User;
import com.mesut.services.UserService;
import jakarta.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author THANHTAIPC
 */
@Controller
public class AuthController {


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView() {
        return "register";
    }

    @PostMapping("/login")
    public String loginProcess(Model model, Locale locale) {
        return "login";
    }

    @PostMapping("/register")
    public String registerProcess(@RequestParam Map<String, String> params,
            Model model, @RequestParam("avatar") MultipartFile avatar
    ) {

        String username = params.get("username");

        User user = this.userService.getUserByUsername(username);

        if (user == null) {
            this.userService.addUser(params, avatar);
            return "redirect:/register?success";
        } else {
            return "redirect:/register?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }

}

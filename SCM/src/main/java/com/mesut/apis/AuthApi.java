///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mesut.apis;
//
//import com.mesut.pojo.User;
//import com.mesut.services.UserService;
//import com.mesut.utils.JwtUtils;
//import java.security.Principal;
//import java.util.Collections;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
///**
// *
// * @author THANHTAI
// */
//@RestController
//@RequestMapping("/api/auth")
//public class AuthApi {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User u) {
//
//        if (this.userService.authenticate(u.getUsername(), u.getPassword())) {
//            try {
//                String token = JwtUtils.generateToken(u.getUsername());
//                return ResponseEntity.ok().body(Collections.singletonMap("token", token));
//            } catch (Exception e) {
//                return ResponseEntity.status(500).body("Lỗi khi tạo JWT");
//            }
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai thông tin đăng nhập");
//    }
//
//    @PostMapping(path = "/register",
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> register(@RequestParam Map<String, String> params, @RequestParam(value = "avatar") MultipartFile avatar) {
//        return new ResponseEntity<>(this.userService.addUser(params, avatar), HttpStatus.CREATED);
//    }
//    
//    @RequestMapping("/profile")
//    public ResponseEntity<User> currentUser(Principal principal) {
//        return new ResponseEntity<>(this.userService.getUserByUsername(principal.getName()), HttpStatus.OK);
//    }
//}

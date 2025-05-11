/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.utils;

import java.util.Date;

/**
 *
 * @author THANHTAIPC
 */
public class CreateDateUtils {
    public static Date createDate(){
        return new java.sql.Date(System.currentTimeMillis());
    }
}

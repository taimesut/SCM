/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.services;

import java.util.List;

/**
 *
 * @author THANHTAIPC
 */
public interface StatsService {

    List<Object[]> currentInventory();

    List<Object[]> expiringInventory(int days); // VD: 30 ngày tới

    List<Object[]> expiredInventory();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import java.util.List;

/**
 *
 * @author THANHTAIPC
 */
public interface StatsRepository {

    List<Object[]> currentInventory();

    List<Object[]> expiringInventory(int days);

    List<Object[]> expiredInventory();
}

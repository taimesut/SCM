/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import java.util.List;

/**
 *
 * @author THANHTAIPC
 * @param <T>
 */
public interface GenericRepository<T> {

    T addOrUpdate(T c);

    List<T> getList();

    T getById(int id);

    void deleteById(int id);
}

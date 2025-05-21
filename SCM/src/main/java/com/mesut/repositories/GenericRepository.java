/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import com.mesut.pojo.Category;
import com.mesut.pojo.Identifiable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author THANHTAIPC
 * @param <T>
 */
public interface GenericRepository<T extends Identifiable> {

    T addOrUpdate(T c);

    List<T> getList();

    T getById(int id);

    void deleteById(int id);

    List<T> getAllWithFilter(Map<String, String> params);

    int countWithFilter(Map<String, String> params);
}

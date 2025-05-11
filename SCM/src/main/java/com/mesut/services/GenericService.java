/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.services;

import com.mesut.utils.Identifiable;
import java.util.List;

/**
 *
 * @author THANHTAIPC
 * @param <T>
 */
public interface GenericService<T extends Identifiable> {
    List<T> getList(); 
    T addOrUpdate(T c);
    T getById(int id);
    void deleteById(int id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.repositories.GenericRepository;
import com.mesut.services.GenericService;
import com.mesut.pojo.Identifiable;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 * @param <T>
 */
@Service
public abstract class GenericServiceImpl<T extends Identifiable> implements GenericService<T> {

    protected final GenericRepository<T> mainRepo;

    protected GenericServiceImpl(GenericRepository<T> repository) {
        this.mainRepo = repository;
    }

    @Override
    public List<T> getList() {
        return this.mainRepo.getList();
    }

    @Override
    public T addOrUpdate(T c) {

        return this.mainRepo.addOrUpdate(c);
    }

    @Override
    public T getById(int id) {
        return this.mainRepo.getById(id);
    }

    @Override
    public void deleteById(int id) {
        this.mainRepo.deleteById(id);
    }

    @Override
    public List<T> getAllWithFilter(Map<String, String> params) {
        return this.mainRepo.getAllWithFilter(params);
    }

    @Override
    public int countWithFilter(Map<String, String> params) {
        return this.mainRepo.countWithFilter(params);
    }

}

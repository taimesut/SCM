/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.services.impl;

import com.mesut.pojo.Supplier;
import com.mesut.repositories.SupplierRepository;
import com.mesut.services.SupplierService;
import com.mesut.utils.CreateDateUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author THANHTAIPC
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository mainRepo;

    @Override
    public Supplier addOrUpdate(Supplier c) {

        return this.mainRepo.addOrUpdate(c);
    }

    @Override
    public List<Supplier> getList() {
        return this.mainRepo.getList();
    }

    @Override
    public Supplier getById(int id) {
        return this.mainRepo.getById(id);
    }

    @Override
    public void deleteById(int id) {
        this.mainRepo.deleteById(id);

    }

}

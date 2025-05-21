/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.repositories.impl;

import com.mesut.pojo.Inventory;
import com.mesut.pojo.Product;
import com.mesut.pojo.Warehouse;
import com.mesut.repositories.InventoryRepository;
import com.mesut.repositories.ProductRepository;
import com.mesut.repositories.WarehouseRepository;
import com.mesut.utils.CreateDateUtils;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InventoryRepositoryImpl extends GenericRepositoryImpl<Inventory> implements InventoryRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;

    public InventoryRepositoryImpl() {
        super(Inventory.class);
    }

    @Override
    public void updateAmount(int warehouse_id, int product_id, int amount_insert) {
        Session s = this.factory.getObject().getCurrentSession();
        Warehouse w = this.warehouseRepository.getById(warehouse_id);
        Product p = this.productRepository.getById(product_id);
        Inventory i = this.findByWarehouseIdAndProductId(w, p);
        if (w == null || p == null) {
            throw new IllegalArgumentException("Warehouse or Product is null");
        }
        if (i != null) {
            i.setAmount(i.getAmount() + amount_insert);
            s.merge(i);
        } else {
            Inventory c = new Inventory();
            c.setAmount(amount_insert);
            c.setProductId(p);
            c.setWarehouseId(w);
            c.setUpdateDate(CreateDateUtils.createDate());
            this.addOrUpdate(c);
        }

    }

    @Override
    public Inventory findByWarehouseIdAndProductId(Warehouse warehouseId, Product productId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Inventory i WHERE i.warehouseId = :warehouseId AND i.productId = :productId", Inventory.class);
        query.setParameter("warehouseId", warehouseId);
        query.setParameter("productId", productId);
        List<Inventory> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<Inventory> getAllWithFilter(Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countWithFilter(Map<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

}

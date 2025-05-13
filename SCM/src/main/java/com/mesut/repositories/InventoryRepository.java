/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import com.mesut.pojo.Inventory;
import com.mesut.pojo.Product;
import com.mesut.pojo.Warehouse;

/**
 *
 * @author THANHTAIPC
 */
public interface InventoryRepository extends GenericRepository<Inventory> {

    void updateAmount(int warehouse_id, int product_id, int amount_insert);

    Inventory findByWarehouseIdAndProductId(Warehouse warehouseId, Product productId);
}

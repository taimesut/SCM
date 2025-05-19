/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import com.mesut.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author THANHTAIPC
 */
public interface ProductRepository extends GenericRepository<Product>{
        List<Product> getProducts(Map<String, String> params);

}

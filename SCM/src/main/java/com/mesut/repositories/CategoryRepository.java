/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mesut.repositories;

import com.mesut.pojo.Category;
import java.util.List;

/**
 *
 * @author THANHTAIPC
 */
public interface CategoryRepository {

    Category addOrUpdateCategory(Category c);

    List<Category> getCategories();

    Category getCategoryById(int id);
    void deleteCategoryById(int id);

}

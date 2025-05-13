/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.formatters;

import com.mesut.pojo.Product;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author THANHTAIPC
 */
public class ProductFormatter implements Formatter<Product> {

    @Override
    public String print(Product object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Product parse(String text, Locale locale) throws ParseException {
        Product c = new Product();
        c.setId(Integer.valueOf(text));
        return c;
    }

}

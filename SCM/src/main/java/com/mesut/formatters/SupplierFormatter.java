/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.formatters;

import com.mesut.pojo.Supplier;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author THANHTAIPC
 */
public class SupplierFormatter implements Formatter<Supplier>{

    @Override
    public String print(Supplier object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Supplier parse(String text, Locale locale) throws ParseException {
        Supplier c = new Supplier();
        c.setId(Integer.valueOf(text));
        return c;
    }
    
}

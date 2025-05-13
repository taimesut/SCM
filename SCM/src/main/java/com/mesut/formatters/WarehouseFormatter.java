/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.formatters;

import com.mesut.pojo.Warehouse;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author THANHTAIPC
 */
public class WarehouseFormatter implements Formatter<Warehouse> {

    @Override
    public String print(Warehouse object, Locale locale) {
        return String.valueOf(object.getId());

    }

    @Override
    public Warehouse parse(String text, Locale locale) throws ParseException {
        Warehouse c = new Warehouse();
        c.setId(Integer.valueOf(text));
        return c;
    }

}

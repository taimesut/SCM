/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.formatters;

import com.mesut.pojo.Shipment;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author THANHTAI
 */
public class ShipmentFormatter implements Formatter<Shipment>{

    @Override
    public String print(Shipment object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Shipment parse(String text, Locale locale) throws ParseException {
        Shipment c = new Shipment();
        c.setId(Integer.valueOf(text));
        return c;
    }
    
}

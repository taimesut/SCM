/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.formatters;

import com.mesut.pojo.ShipmentCompany;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author THANHTAIPC
 */
public class ShipmentCompanyFormatter implements Formatter<ShipmentCompany> {

    @Override
    public String print(ShipmentCompany object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public ShipmentCompany parse(String text, Locale locale) throws ParseException {
        ShipmentCompany c = new ShipmentCompany();
        c.setId(Integer.valueOf(text));
        return c;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.formatters;

import com.mesut.pojo.ReceiptImport;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author THANHTAIPC
 */
public class ReceiptImportFormatter implements Formatter<ReceiptImport>{

    @Override
    public String print(ReceiptImport object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public ReceiptImport parse(String text, Locale locale) throws ParseException {
        ReceiptImport c = new ReceiptImport();
        c.setId(Integer.valueOf(text));
        return c;
    }
    
}

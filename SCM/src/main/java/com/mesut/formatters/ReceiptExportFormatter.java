/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.formatters;

import com.mesut.pojo.ReceiptExport;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author THANHTAIPC
 */
public class ReceiptExportFormatter implements Formatter<ReceiptExport>{

    @Override
    public String print(ReceiptExport object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public ReceiptExport parse(String text, Locale locale) throws ParseException {
        ReceiptExport c = new ReceiptExport();
        c.setId(Integer.valueOf(text));
        return c;
    }
    
}

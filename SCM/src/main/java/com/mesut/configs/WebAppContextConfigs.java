/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.configs;

import com.mesut.formatters.CategoryFormatter;
import com.mesut.formatters.ProductFormatter;
import com.mesut.formatters.ReceiptExportFormatter;
import com.mesut.formatters.ReceiptImportFormatter;
import com.mesut.formatters.ShipmentCompanyFormatter;
import com.mesut.formatters.ShipmentFormatter;
import com.mesut.formatters.SupplierFormatter;
import com.mesut.formatters.UserFormatter;
import com.mesut.formatters.WarehouseFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author THANHTAIPC
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.mesut.controllers",
    "com.mesut.repositories",
    "com.mesut.services"
})
public class WebAppContextConfigs implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CategoryFormatter());
        registry.addFormatter(new ProductFormatter());
        registry.addFormatter(new WarehouseFormatter());
        registry.addFormatter(new SupplierFormatter());
        registry.addFormatter(new UserFormatter());
        registry.addFormatter(new ReceiptImportFormatter());
        registry.addFormatter(new ReceiptExportFormatter());
        registry.addFormatter(new ShipmentCompanyFormatter());
        registry.addFormatter(new ShipmentFormatter());

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");

    }

    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}

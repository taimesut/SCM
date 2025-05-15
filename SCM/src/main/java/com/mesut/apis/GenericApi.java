/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mesut.apis;

import com.mesut.pojo.Identifiable;
import com.mesut.services.GenericService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author THANHTAIPC
 */
public abstract class GenericApi<T extends Identifiable> {

    protected final GenericService<T> mainService;

    public GenericApi(GenericService<T> service) {
        this.mainService = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody T entity) {
        return ResponseEntity.ok(this.mainService.addOrUpdate(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody T entity) {
        if (this.mainService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        if (entity.getId() != null && !entity.getId().equals(id)) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "ID in path and body do not match")
            );
        }

        return ResponseEntity.ok(this.mainService.addOrUpdate(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") int id) {
        T result = this.mainService.getById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.mainService.getList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (this.mainService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        mainService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

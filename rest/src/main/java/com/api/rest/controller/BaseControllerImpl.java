package com.api.rest.controller;

import com.api.rest.exception.BusinessException;
import com.api.rest.interfaces.BaseController;
import com.api.rest.model.Base;
import com.api.rest.service.BaseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/* MEJORAR CADA OVERRIDE CREO Q EN RESPONSE ENTITY*/
public abstract class BaseControllerImpl < E extends Base, S extends BaseServiceImpl<E,Integer>> implements BaseController<E,Integer> {
    @Autowired
    protected S service;

    @Override
    @GetMapping(path = {"/people"})
    public ResponseEntity<?> getAllRecords() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            throw new BusinessException("500", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    @GetMapping(path = {"/people/page"})
    public ResponseEntity<?> getRecordBy(Pageable pageable,
                                         @RequestParam(name = "sort", required = false) String sort) {
        try {
            if (sort != null) {
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        } catch (Exception e) {
            throw new BusinessException("500", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    @GetMapping(path = {"/person/{id}"})
    public ResponseEntity<?> getRecordById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "No se encontró el registro con ese id")) {
                throw new BusinessException("404", HttpStatus.NOT_FOUND, e.getMessage());
            }else{
                throw new BusinessException("500", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
    }

    @Override
    @PostMapping(path = {"/person"})
    public ResponseEntity<?> saveRecord(@Valid @RequestBody E entity, BindingResult result) {
        if (result.hasErrors()) {
            throw new BusinessException("406", HttpStatus.NOT_ACCEPTABLE, "Campos obligatorios invalidos");
        } else {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
            } catch (Exception e) {
                if (Objects.equals(e.getMessage(), "No se encontró el registro con ese id")) {
                    throw new BusinessException("404", HttpStatus.NOT_FOUND, e.getMessage());
                }else{
                    throw new BusinessException("500", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
                }
            }
        }
    }

    @Override
    @PutMapping(path = {"/person/{id}"})
    public ResponseEntity<?> updateRecord(@PathVariable Integer id, @RequestBody E entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id,entity));
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "No se encontró el registro con ese id")) {
                throw new BusinessException("404", HttpStatus.NOT_FOUND, e.getMessage());
            }else{
                throw new BusinessException("500", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
    }

    @Override
    @DeleteMapping(path = {"/person/{id}"})
    public ResponseEntity<?> deleteRecord(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "No se encontró el registro con ese id")) {
                throw new BusinessException("404", HttpStatus.NOT_FOUND, e.getMessage());
            }else{
                throw new BusinessException("500", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
    }

}

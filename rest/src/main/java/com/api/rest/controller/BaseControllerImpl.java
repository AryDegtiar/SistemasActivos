package com.api.rest.controller;

import com.api.rest.interfaces.BaseController;
import com.api.rest.model.Base;
import com.api.rest.model.Persona;
import com.api.rest.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* MEJORAR CADA OVERRIDE CREO Q EN RESPONSE ENTITY*/
public abstract class BaseControllerImpl < E extends Base, S extends BaseServiceImpl<E,Integer>> implements BaseController<E,Integer> {
    @Autowired
    protected S service;

    @Override
    @GetMapping(path = {"/persons","/persons/"})
    public ResponseEntity<?> getAllRecords() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    /* REVISAR */
    @Override
    @GetMapping(path = {"/persons/page","/persons/page/"})
    public ResponseEntity<?> getRecordBy(@PageableDefault(size = 20) Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    @Override
    @GetMapping(path = {"/person/{id}","/person/{id}/"})
    public ResponseEntity<?> getRecordById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    @Override
    @PostMapping(path = {"/person","/person/"})
    public ResponseEntity<?> saveRecord(@RequestBody E entity) {
        if (true) { // falta validar campos
            System.out.println("Es una persona");
            try {
                /*
                HttpHeaders headers = new HttpHeaders();
                headers.add("Mi-Encabezado", "999");
                String mensaje = "Mensaje de respuesta";
                return new ResponseEntity<>(mensaje, headers, HttpStatus.OK);
                 */
                return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
            }
        } else {
            System.out.println("No es una persona");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los campos no son validos");
        }
    }

    @Override
    @PutMapping(path = {"/person/{id}","/person/{id}/"})
    public ResponseEntity<?> updateRecord(@PathVariable Integer id, @RequestBody E entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id,entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    @Override
    @DeleteMapping(path = {"/person/{id}","/person/{id}/"})
    public ResponseEntity<?> deleteRecord(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

}

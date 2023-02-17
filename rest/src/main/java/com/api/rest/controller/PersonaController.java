package com.api.rest.controller;


import com.api.rest.model.Persona;
import com.api.rest.service.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

}
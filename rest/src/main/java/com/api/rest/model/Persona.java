package com.api.rest.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Setter @Getter
@Entity
@Table(name = "personas")
public class Persona extends Base{

    @NotNull @NotBlank @NotEmpty
    private String nombre;
    @NotNull @NotBlank @NotEmpty
    private String apellido;
    @NotNull @NotBlank @NotEmpty
    private String usuario;
    @NotNull @NotBlank @NotEmpty
    private String clave;

    public Persona() {
        super();
    }

    public Persona(String nombre, String apellido, String usuario, String clave) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
    }

}


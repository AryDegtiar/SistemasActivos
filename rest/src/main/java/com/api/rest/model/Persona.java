package com.api.rest.model;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Setter @Getter
@Entity
@Table(name = "personas")
public class Persona extends Base{

    private String nombre;

    private String apellido;

    private String usuario;

    private String clave;

    public Persona() {
        super();
    }

}

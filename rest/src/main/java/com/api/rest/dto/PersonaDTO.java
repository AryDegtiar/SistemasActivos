package com.api.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PersonaDTO {
    @NotNull @NotBlank @NotEmpty
    private String nombre;
    @NotNull @NotBlank @NotEmpty
    private String apellido;
    @NotNull @NotBlank @NotEmpty
    private String usuario;
    @NotNull @NotBlank @NotEmpty
    private String clave;
}
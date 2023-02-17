package com.api.rest.repository;

import com.api.rest.model.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Integer> {

    public Persona findByUsuario(String usuario);
}

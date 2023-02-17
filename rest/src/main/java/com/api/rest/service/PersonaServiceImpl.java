package com.api.rest.service;

import com.api.rest.interfaces.PersonaService;
import com.api.rest.model.Persona;
import com.api.rest.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Integer> implements PersonaService {

    public PersonaServiceImpl(BaseRepository<Persona, Integer> baseRepository) {
        super(baseRepository);
    }

}

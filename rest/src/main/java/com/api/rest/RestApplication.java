package com.api.rest;

import com.api.rest.model.Persona;
import com.api.rest.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Autowired
	PersonaRepository personaRepository;

	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			if (args.length > 0) {
				System.out.println(args[0]);
			}

			personaRepository.save(new Persona("Ricardo", "Piciano", "richardPici", "123"));
			personaRepository.save(new Persona("Micaela", "Paez", "mikiPaez", "456"));
			personaRepository.save(new Persona("Ñadnu", "Estocolmo", "ñanduEsto", "789"));

		};
	}

}

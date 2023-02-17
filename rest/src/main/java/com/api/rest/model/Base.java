package com.api.rest.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter @Setter
@MappedSuperclass
public class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personaId;

    public Base() {
        super();
    }
}

package com.org.utb.app.librarytech.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AddressDTO implements Serializable {

    //Identificación
    private Long id;

    //Nombre
    private String name;

    public AddressDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AddressDTO() {
    }
}

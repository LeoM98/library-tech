package com.org.utb.app.librarytech.dto;

import com.org.utb.app.librarytech.entities.Library;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO implements Serializable {

    //Identificación
    private Long id;

    //Nombre
    private String name;

    // Library
    private Library library;

}

package com.org.utb.app.librarytech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO implements Serializable {

    //Identificación
    private Long id;

    //Nombre
    private String name;

    // Antiguo
    private int time;

}

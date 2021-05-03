package com.org.utb.app.librarytech.exceptions;

public class NoLibraryFoundId extends RuntimeException{

    public NoLibraryFoundId(Long id) {
        super(String.format("La dirección con id %d no existe",id));
    }
}

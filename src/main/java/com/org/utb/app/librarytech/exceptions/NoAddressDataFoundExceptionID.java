package com.org.utb.app.librarytech.exceptions;

public class NoAddressDataFoundExceptionID extends RuntimeException {

    public NoAddressDataFoundExceptionID(Long id) {
        super(String.format("La dirección con id %d no existe",id));
    }
}

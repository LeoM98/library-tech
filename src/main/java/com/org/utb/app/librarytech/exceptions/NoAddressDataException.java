package com.org.utb.app.librarytech.exceptions;

public class NoAddressDataException extends RuntimeException {

    public NoAddressDataException() {
        super("No address found");
    }
}

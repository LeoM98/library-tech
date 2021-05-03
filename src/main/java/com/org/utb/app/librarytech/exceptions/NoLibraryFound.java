package com.org.utb.app.librarytech.exceptions;

public class NoLibraryFound extends RuntimeException {

    public NoLibraryFound() {
        super("No library found");
    }
}

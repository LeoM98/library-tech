package com.org.utb.app.librarytech.services;

import com.org.utb.app.librarytech.dto.LibraryDTO;
import com.org.utb.app.librarytech.entities.Library;

import java.util.List;

public interface LibraryService {

    List<LibraryDTO> findAll();
    LibraryDTO save(Library library);
    LibraryDTO findById(Long id);
    LibraryDTO update(Library library, Long id);
    void delete(Long id);
}

package com.org.utb.app.librarytech.services.Impl;

import com.org.utb.app.librarytech.dto.LibraryDTO;
import com.org.utb.app.librarytech.entities.Library;
import com.org.utb.app.librarytech.repositories.LibraryRepository;
import com.org.utb.app.librarytech.services.LibraryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<LibraryDTO> findAll() {

        return ((List<Library>) libraryRepository
                .findAll())
                .stream()
                .map(this::convertToLibraryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryDTO save(Library library) {

        LibraryDTO libraryDTO = new LibraryDTO();
        BeanUtils.copyProperties(library, libraryDTO);

        libraryRepository.save(library);
        return libraryDTO;
    }

    @Override
    public LibraryDTO findById(Long id) {

        LibraryDTO libraryDTO = new LibraryDTO();
        BeanUtils.copyProperties(libraryRepository.findById(id).orElse(null), libraryDTO);
        if (libraryDTO == null){
            return null;
        }

        return libraryDTO;
    }

    @Override
    public LibraryDTO update(Library library, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    //Convert to DTO
    private LibraryDTO convertToLibraryDTO(Library library) {
        LibraryDTO libraryDTO = new LibraryDTO();
        BeanUtils.copyProperties(library,libraryDTO);

        return libraryDTO;
    }
}

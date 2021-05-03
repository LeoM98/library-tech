package com.org.utb.app.librarytech.controller;

import com.org.utb.app.librarytech.dto.LibraryDTO;
import com.org.utb.app.librarytech.entities.Library;
import com.org.utb.app.librarytech.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<LibraryDTO> findAll(){
        return libraryService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryDTO save(@Valid @RequestBody Library library){
        return libraryService.save(library);
    }

    @GetMapping("/{id}")
    public LibraryDTO findById(@PathVariable Long id){
        return libraryService.findById(id);
    }

}

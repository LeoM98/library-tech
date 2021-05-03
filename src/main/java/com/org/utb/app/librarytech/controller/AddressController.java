package com.org.utb.app.librarytech.controller;

import com.org.utb.app.librarytech.dto.AddressDTO;
import com.org.utb.app.librarytech.dto.LibraryDTO;
import com.org.utb.app.librarytech.entities.Address;
import com.org.utb.app.librarytech.entities.Library;
import com.org.utb.app.librarytech.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDTO> findAll(){
        return addressService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO save(@Valid @RequestBody Address address){
        return addressService.save(address);
    }

    @GetMapping("/{id}")
    public AddressDTO findById(@PathVariable Long id){
        return addressService.findById(id);
    }
}

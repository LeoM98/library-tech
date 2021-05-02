package com.org.utb.app.librarytech.services;

import com.org.utb.app.librarytech.dto.AddressDTO;
import com.org.utb.app.librarytech.entities.Address;

import java.util.List;

public interface AddressService {

    List<AddressDTO> findAll();
    AddressDTO save(Address address);
    AddressDTO findById(Long id);
    AddressDTO update(Address address, Long id);
    void delete(Long id);
}

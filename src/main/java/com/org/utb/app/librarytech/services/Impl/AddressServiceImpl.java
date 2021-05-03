package com.org.utb.app.librarytech.services.Impl;

import com.org.utb.app.librarytech.dto.AddressDTO;
import com.org.utb.app.librarytech.entities.Address;
import com.org.utb.app.librarytech.repositories.AddressRepository;
import com.org.utb.app.librarytech.services.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressDTO> findAll() {

        return ((List<Address>) addressRepository
                .findAll())
                .stream()
                .map(this::convertToAddresDTO)
                .collect(Collectors.toList());

    }

    @Override
    public AddressDTO save(Address address) {

        AddressDTO addressDTOS = new AddressDTO();
        BeanUtils.copyProperties(address,addressDTOS);
        addressRepository.save(address);

        return addressDTOS;
    }

    @Override
    public AddressDTO findById(Long id) {

        AddressDTO addressDTOS = new AddressDTO();
        BeanUtils.copyProperties(addressRepository.findById(id).orElse(null), addressDTOS);
        return addressDTOS;
    }

    @Override
    public AddressDTO update(Address address, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    //Convert to DTO
    private AddressDTO convertToAddresDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(address,addressDTO);

        return addressDTO;
    }

}

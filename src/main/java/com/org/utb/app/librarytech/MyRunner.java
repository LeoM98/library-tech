package com.org.utb.app.librarytech;

import com.org.utb.app.librarytech.entities.Address;
import com.org.utb.app.librarytech.repositories.AddressRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    private AddressRepository addressRepository;

    @Autowired
    public MyRunner(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Saving address");
        addressRepository.save(Address.builder().name("Gaviotas").build());
        addressRepository.save(Address.builder().name("Medellín").build());
        addressRepository.save(Address.builder().name("Cartagena").build());
        addressRepository.save(Address.builder().name("Bogotá").build());
    }
}

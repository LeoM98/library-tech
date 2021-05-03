package com.org.utb.app.librarytech;

import com.org.utb.app.librarytech.entities.Address;
import com.org.utb.app.librarytech.entities.Library;
import com.org.utb.app.librarytech.repositories.AddressRepository;
import com.org.utb.app.librarytech.repositories.LibraryRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    private AddressRepository addressRepository;
    private LibraryRepository libraryRepository;

    @Autowired
    public MyRunner(AddressRepository addressRepository, LibraryRepository libraryRepository) {
        this.addressRepository = addressRepository;
        this.libraryRepository = libraryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Saving address");
        addressRepository.save(Address.builder().name("Gaviotas").build());
        addressRepository.save(Address.builder().name("Medellín").build());
        addressRepository.save(Address.builder().name("Cartagena").build());
        addressRepository.save(Address.builder().name("Bogotá").build());

        logger.info("Saving library");
        libraryRepository.save(Library.builder().name("UTB").time(2010).build());
        libraryRepository.save(Library.builder().name("POZÓN").time(2012).build());
        libraryRepository.save(Library.builder().name("ARENAL").time(2013).build());
        libraryRepository.save(Library.builder().name("REPELÓN").time(2014).build());

    }
}

package com.org.utb.app.librarytech.repositories;

import com.org.utb.app.librarytech.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

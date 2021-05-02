package com.org.utb.app.librarytech.repositories;

import com.org.utb.app.librarytech.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}

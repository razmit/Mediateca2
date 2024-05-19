package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findById(Long aLong);
}

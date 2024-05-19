package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    Optional<Prestamo> findById(Long aLong);
}

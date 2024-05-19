package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.DocumentoMateria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentoMateriaRepository extends JpaRepository<DocumentoMateria, Long> {

    Optional<DocumentoMateria> findById(Long aLong);
}

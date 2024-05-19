package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    Optional<Materia> findById(Long aLong);
}

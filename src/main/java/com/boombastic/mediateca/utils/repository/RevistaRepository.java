package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Revista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RevistaRepository extends JpaRepository<Revista, Long> {

    Optional<Revista> findById(Long aLong);
}

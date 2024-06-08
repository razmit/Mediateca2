package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    Optional<Documento> findById(Long aLong);

}

package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {

    Optional<TipoDocumento> findById(Long aLong);
}

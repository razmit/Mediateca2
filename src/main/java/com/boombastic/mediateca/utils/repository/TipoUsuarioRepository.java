package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.TipoUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarios, Long> {

    TipoUsuarios findByNombre(String nombre);
}

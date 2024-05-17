package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Override
    Optional<Usuario> findById(Long aLong);

    Optional<Usuario> findByCantidad_moraBetweenAndAndCantidad_moraBeforeOrCodigo_usuario(String email);
}

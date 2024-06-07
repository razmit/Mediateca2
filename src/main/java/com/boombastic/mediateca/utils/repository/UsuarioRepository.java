package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long aLong);

//    @Query("SELECT u from Usuario u WHERE ");

    Usuario findByNombreUsuario(String nombreUsuario);
    Usuario findByContrasena(String contrasena);

    Optional<Usuario> getAllByNombreUsuario(String aString);
}

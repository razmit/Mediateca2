package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CDRepository extends JpaRepository<CD, Long> {

    Optional<CD> findById(Long aLong);

    @Query("SELECT cd FROM CD cd JOIN FETCH cd.documento doc") // Obtener todos los CDs con sus respectivos Doc
    List<CD> getAllCDs();

    @Query("SELECT cd FROM CD cd JOIN FETCH cd.documento doc WHERE " +
            "cd.artista LIKE :keyword OR " +
            "cd.genero LIKE :keyword OR " +
            "cd.documento.titulo LIKE :keyword OR " +
            "CAST(cd.documento.anoPublicacion AS string ) LIKE :keyword OR " +
            "CAST(cd.duracion AS string) LIKE :keyword OR " +
            "CAST(cd.numCanciones AS string) LIKE :keyword")
    List<CD> searchAllCDs(String keyword);
}

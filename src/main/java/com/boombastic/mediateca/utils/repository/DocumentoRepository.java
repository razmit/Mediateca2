package com.boombastic.mediateca.utils.repository;

import com.boombastic.mediateca.utils.models.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    Optional<Documento> findById(Long aLong);

//    @Query("SELECT doc, td, mat FROM Documento doc LEFT JOIN doc.tipoDocumento td " +
//            "LEFT JOIN doc.docMateriaList md " +
//            "LEFT JOIN md.materia mat")
    @Query("SELECT d, m FROM Documento d LEFT JOIN d.docMateriaList m")
    List<Documento> findAllDocumentosWithDetails();
}

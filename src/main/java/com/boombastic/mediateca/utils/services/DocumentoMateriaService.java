package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.dtos.DocumentoMateriaDto;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.CD;
import com.boombastic.mediateca.utils.models.DocumentoMateria;
import com.boombastic.mediateca.utils.models.Usuario;

import java.util.List;

public interface DocumentoMateriaService {

    List<DocumentoMateriaDto> listAllDocumentoMaterias();
    DocumentoMateria saveDM(DocumentoMateria dm);

    DocumentoMateriaDto findDMById(Long dmId);

    void updateDM(DocumentoMateriaDto dmDto);

    void delete(Long dmId);
}

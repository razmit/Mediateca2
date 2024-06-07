package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.DocumentoRepository;
import com.boombastic.mediateca.utils.repository.TipoDocumentoRepository;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoServiceImpl {

    private DocumentoRepository documentoRepository;
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    public DocumentoServiceImpl(DocumentoRepository documentoRepository, TipoDocumentoRepository tipoDocumentoRepository) {
        this.documentoRepository = documentoRepository;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }


}

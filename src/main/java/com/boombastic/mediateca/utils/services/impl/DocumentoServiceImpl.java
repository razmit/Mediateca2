package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.dtos.DocumentoDto;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.CD;
import com.boombastic.mediateca.utils.models.Documento;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.DocumentoRepository;
import com.boombastic.mediateca.utils.repository.TipoDocumentoRepository;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import com.boombastic.mediateca.utils.services.DocumentoService;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    private DocumentoRepository documentoRepository;
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    public DocumentoServiceImpl(DocumentoRepository documentoRepository, TipoDocumentoRepository tipoDocumentoRepository) {
        this.documentoRepository = documentoRepository;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Override
    public List<DocumentoDto> getDocumentos() {
        List<Documento> documentos = documentoRepository.findAllDocumentosWithDetails();
        return documentos.stream().map(this::mapToDocumentoDto).collect(Collectors.toList());
    }

    @Override
    public void savedocs(Documento doc) {

    }

    @Override
    public DocumentoDto findDocById(Long docId) {
        return null;
    }

    @Override
    public void updateDoc(DocumentoDto documentoDto) {

    }

    @Override
    public void delete(Long DocId) {

    }

    public DocumentoDto mapToDocumentoDto(Documento doc) {
        return DocumentoDto.builder()
                .id(doc.getIdDocumento())
                .tipoDocumento(doc.getTipoDocumento())
                .titulo(doc.getTitulo())
                .autor(doc.getAutor())
                .anoPublicacion(doc.getAnoPublicacion())
                .ubicacionFisica(doc.getUbicacionFisica())
                .cantidadDisponible(doc.getCantidadDisponible())
                .estado(doc.getEstado())
                .fechaAdquisicion(doc.getFechaAdquisicion())
                .materia(doc.getDocMateriaList())
                .build();
    }
}

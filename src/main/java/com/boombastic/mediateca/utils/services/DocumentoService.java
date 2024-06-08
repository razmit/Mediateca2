package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.DocumentoDto;
import com.boombastic.mediateca.utils.models.Documento;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface DocumentoService {
    List<DocumentoDto> getDocumentos();
    void savedocs(Documento doc);

    DocumentoDto findDocById(Long docId);

    void updateDoc(DocumentoDto documentoDto);

    void delete(Long DocId);
}

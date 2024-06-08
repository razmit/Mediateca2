package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.DocumentoDto;
import com.boombastic.mediateca.utils.models.CD;
import com.boombastic.mediateca.utils.models.Documento;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public interface DocumentoService {
    void savedocs(Documento doc);

    DocumentoDto findDocById(Long docId);

    void updateDoc(DocumentoDto documentoDto);

    void delete(Long DocId);
}

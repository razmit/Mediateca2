package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.DocumentoDto;
import com.boombastic.mediateca.utils.models.CD;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public interface DocumentoService {
    List<DocumentoDto> listAlldocumentos();
    CD savedocs(Doc doc);

    DocumentoDto findDocById(Long docId);

    void updateDoc(DocumentoDto documentoDto);

    void delete(Long DocId);
}

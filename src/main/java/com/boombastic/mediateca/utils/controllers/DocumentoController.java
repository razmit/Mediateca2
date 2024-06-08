package com.boombastic.mediateca.utils.controllers;
import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.dtos.DocumentoDto;
import com.boombastic.mediateca.utils.models.Documento;
import com.boombastic.mediateca.utils.services.CDService;
import com.boombastic.mediateca.utils.services.DocumentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.Doc;
import java.util.List;

@Controller
public class DocumentoController {
    private DocumentoService documentoService;
    private CDService cdService;

    @Autowired
    public DocumentoController(DocumentoService documentoService, CDService cdService) {
        this.documentoService = documentoService;
        this.cdService = cdService;
    }

    @GetMapping("/documentos")
    public String listDocumentos(Model model){
        List<CDDto> cds = cdService.listAllCDs();
        model.addAttribute("cds", cds);
        return "general-docs";
    }

    @GetMapping("/docs/{docId}")
    public String docDetail(@PathVariable("docId") Long docId, Model model){
        DocumentoDto documentoDto = documentoService.findDocById(docId);
        model.addAttribute("doc", documentoDto);
        return "doc-detail";
    }

    @GetMapping("/docs/new")
    public String createDocForm(Model model) {
        Documento documento = new Documento();
        model.addAttribute("doc", documento);
        return "documentos-create";
    }

    @PostMapping("/docs/new")
    public String saveDocumento(@ModelAttribute("doc") Documento documento) {
        documentoService.savedocs((Documento) documento);
        return "redirect:/cds";
    }

    @GetMapping("/docs/{docId}/edit")
    public String editDocumentosForm(@PathVariable("docId") Long docId, Model model) {
        DocumentoDto documentoDto = documentoService.findDocById(docId);
        model.addAttribute("documentoDto", documentoDto);
        return "docs-edit";
    }

    @PostMapping("/docs/{docId}/edit")
    public String updateDocumento(@PathVariable("docId") Long docId,
                           @Valid @ModelAttribute("documentos") DocumentoDto documentoDto,
                           BindingResult result,
                           Model model){

        if (result.hasErrors()) {
            documentoDto = documentoService.findDocById(docId);
            model.addAttribute("docDto", documentoDto);
            return "docs-edit";
        }
        documentoDto.setId(docId);
        documentoService.updateDoc(documentoDto);
        return "redirect:/docs";
    }

    @GetMapping("/docs/{docId}/delete")
    public String deleteDoc(@PathVariable("docId") Long docId) {
        documentoService.delete(docId);
        return "redirect:/documentos";
    }
}




package com.boombastic.mediateca.utils.controllers;

import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.models.CD;
import com.boombastic.mediateca.utils.services.CDService;
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

import java.util.List;

@Controller
public class CDController {

    private CDService cdService;

    @Autowired
    public CDController(CDService cdService) {
        this.cdService = cdService;
    }

    @GetMapping("/documentos/cds")
    public String listCDs(Model model){
        List<CDDto> cds = cdService.listAllCDs();
        model.addAttribute("cds", cds);
        return "cds-list";
    }

    @GetMapping("/documentos/cds/{cdId}")
    public String cdDetail(@PathVariable("cdId") Long cdId, Model model){
        CDDto cdDto = cdService.findCDById(cdId);
        model.addAttribute("cd", cdDto);
        return "cd-detail";
    }

    @GetMapping("/documentos/cds/new")
    public String createCDForm(Model model) {
        CD cd = new CD();
        model.addAttribute("cd", cd);
        return "cds-create";
    }

    @PostMapping("/documentos/cds/new")
    public String saveCD(@ModelAttribute("cd") CDDto cdDto) {
        cdService.saveCD(cdDto);
        return "redirect:/cds";
    }

    @GetMapping("/documentos/cds/{cdId}/edit")
    public String editCDForm(@PathVariable("cdId") Long cdId, Model model) {
        CDDto cdDto = cdService.findCDById(cdId);
        model.addAttribute("cdDto", cdDto);
        return "cds-edit";
    }

    @PostMapping("/documentos/cds/{cdId}/edit")
    public String updateCD(@PathVariable("cdId") Long cdId,
                           @Valid @ModelAttribute("cd") CDDto cdDto,
                           BindingResult result,
                           Model model){

        if (result.hasErrors()) {
            cdDto = cdService.findCDById(cdId);
            model.addAttribute("cdDto", cdDto);
            return "cds-edit";
        }
        cdDto.setId(cdId);
        cdService.updateCD(cdDto);
        return "redirect:/cds";
    }

    @GetMapping("/documentos/cds/{cdId}/delete")
    public String deleteCD(@PathVariable("cdId") Long cdId) {
        cdService.delete(cdId);
        return "redirect:/documentos/cds";
    }
}

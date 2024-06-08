package com.boombastic.mediateca.utils.controllers;

import com.boombastic.mediateca.utils.dtos.TesisDto;
import com.boombastic.mediateca.utils.services.TesisService;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TesisController {

    private TesisService tesisService;

    @Autowired
    public TesisController(TesisService tesisService){
        this.tesisService = tesisService;
    }

    @GetMapping("/tesis")
    public String listTesis(Model model){
        List<TesisDto> tesisList = tesisService.listAllTesis();
        model.addAttribute("tesisList", tesisList);
        return "tesis-list";
    }

    @GetMapping("/tesis/{tesisId}")
    public String tesisDetail(@PathVariable("tesisId") Long tesisId, Model model){
        TesisDto tesisDto = tesisService.findTesisById(tesisId);
        model.addAttribute("tesis", tesisDto);
        return "tesis-detail";
    }

    @GetMapping("/tesis/new")
    public String createTesisForm(Model model) {
        TesisDto tesisDto = new TesisDto();
        model.addAttribute("tesis", tesisDto);
        return "tesis-create";
    }

    @PostMapping("/tesis/new")
    public String saveTesis(@ModelAttribute("tesis") @Valid TesisDto tesisDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "tesis-create";
        }
        tesisService.saveTesis(tesisDto);
        return "redirect:/tesis";
    }

    @GetMapping("/tesis/{tesisId}/edit")
    public String editTesisForm(@PathVariable("tesisId") Long tesisId, Model model) {
        TesisDto tesisDto = tesisService.findTesisById(tesisId);
        model.addAttribute("tesisDto", tesisDto);
        return "tesis-edit";
    }

    @PostMapping("/tesis/{tesisId}/edit")
    public String updateTesis(@PathVariable("tesisId") Long tesisId,
                              @Valid @ModelAttribute("tesis") TesisDto tesisDto,
                              BindingResult result,
                              Model model){

        if (result.hasErrors()) {
            tesisDto = tesisService.findTesisById(tesisId);
            model.addAttribute("tesisDto", tesisDto);
            return "tesis-edit";
        }
        tesisDto.setId(tesisId);
        tesisService.updateTesis(tesisDto);
        return "redirect:/tesis";
    }

    @GetMapping("/tesis/{tesisId}/delete")
    public String deleteTesis(@PathVariable("tesisId") Long tesisId) {
        tesisService.delete(tesisId);
        return "redirect:/tesis";
    }

}

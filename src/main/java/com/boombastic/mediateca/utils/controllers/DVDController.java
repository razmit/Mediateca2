package com.boombastic.mediateca.utils.controllers;


import com.boombastic.mediateca.utils.dtos.DVDDto;
import com.boombastic.mediateca.utils.models.DVD;
import com.boombastic.mediateca.utils.services.DVDService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DVDController {

    private DVDService dvdService;

    @Autowired
    public DVDController(DVDService dvdService) {
        this.dvdService = dvdService;
    }

    @GetMapping("/dvds")
    public String listDvds(Model model){
        List<DVDDto> dvds = dvdService.listAllDvds();
        model.addAttribute("dvds", dvds);
        return "dvds-list";
    }

    @GetMapping("/dvds/{dvdId}")
    public String dvdDetail(@PathVariable("dvdId") Long dvdId, Model model){
        DVDDto dvdDto = dvdService.findDvdById(dvdId);
        model.addAttribute("dvd", dvdDto);
        return "dvd-detail";
    }

    @GetMapping("/dvds/new")
    public String createDvdForm(Model model) {
        DVD dvd = new DVD();
        model.addAttribute("dvd", dvd);
        return "dvds-create";
    }

    @PostMapping("/dvds/new")
    public String saveDvd(@ModelAttribute("dvd") DVDDto dvd) {
        dvdService.saveDvd(dvd);
        return "redirect:/dvds";
    }

    @GetMapping("/dvds/{dvdId}/edit")
    public String editDvdForm(@PathVariable("dvdId") Long dvdId, Model model) {
        DVDDto dvdDto = dvdService.findDvdById(dvdId);
        model.addAttribute("dvdDto", dvdDto);
        return "dvds-edit";
    }

    @PostMapping("/dvds/{dvdId}/edit")
    public String updateDvd(@PathVariable("dvdId") Long dvdId,
                            @Valid @ModelAttribute("dvd") DVDDto dvddto,
                            BindingResult result,
                            Model model){

        if (result.hasErrors()) {
            dvddto = dvdService.findDvdById(dvdId);
            model.addAttribute("dvdDto", dvddto);
            return "dvds-edit";
        }
        dvddto.setId(dvdId);
        dvdService.updateDvd(dvddto);
        return "redirect:/dvds";
    }

    @GetMapping("/dvds/{dvdId}/delete")
    public String deleteDvd(@PathVariable("dvdId") Long dvdId) {
        dvdService.delete(dvdId);
        return "redirect:/dvds";
    }
}
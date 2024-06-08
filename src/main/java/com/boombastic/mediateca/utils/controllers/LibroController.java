package com.boombastic.mediateca.utils.controllers;

import ch.qos.logback.core.model.Model;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.dtos.LibroDto;
import com.boombastic.mediateca.utils.models.Libro;
import com.boombastic.mediateca.utils.services.LibroService;
import com.boombastic.mediateca.utils.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




import java.util.List;

@Controller
public class LibroController {

    private LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService){this.libroService= libroService;}

    @GetMapping("/libros")
    public String listLibros(org.springframework.ui.Model model){
        List<LibroDto> libros = libroService.listAllLibros();
        model.addAttribute("libros", libros);
        return "usuarios-list";
    }

    @GetMapping("/libros/new")
    public String createLibroForm(org.springframework.ui.Model model) {
        Libro libro = new Libro();
        model.addAttribute("libro", libro);
        return "libros-create";
    }

    @PostMapping("/libros/new")
    public String saveLibro(@ModelAttribute("libro") Libro libro) {
        libroService.saveLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/libros/{libroId}/edit")
    public String editLibroForm(@PathVariable("libroId") Long libroId, org.springframework.ui.Model model) {
        LibroDto libroDto = libroService.findLibroById(libroId);
        model.addAttribute("libroDto", libroDto);
        return "libros-edit";
    }



    @PostMapping("/libros/{libroId}/edit")
    public String updateLibro(@PathVariable("libroId") Long libroId,
                              @Valid @ModelAttribute("libro") LibroDto libroDto,
                              BindingResult result, org.springframework.ui.Model model){

        if (result.hasErrors()) {
            libroDto = libroService.findLibroById(libroId);
            model.addAttribute("libroDto", libroDto);
            return "libros-edit";
        }

        libroDto.setId(libroId);
        libroService.updateLibro(libroDto);
        return "redirect:/libros";
    }

    @GetMapping("/libros/{libroId}/delete")
    public String deleteLibro(@PathVariable("libroId") Long libroId) {
        libroService.delete(libroId);
        return "redirect:/libros";
    }
}

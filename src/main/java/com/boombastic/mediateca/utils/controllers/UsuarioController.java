package com.boombastic.mediateca.utils.controllers;

import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.services.UsuarioService;
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
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public String listUsuarios(Model model){
        List<UsuarioDto> usuarios = usuarioService.listAllUsers();
        model.addAttribute("usuarios", usuarios);
        return "usuarios-list";
    }

    @GetMapping("/usuarios/{usuarioId}")
    public String usuarioDetail(@PathVariable("usuarioId") Long usuarioId, Model model){
        UsuarioDto usuarioDto = usuarioService.findUsuarioById(usuarioId);
        model.addAttribute("usuario", usuarioDto);
        return "usuario-detail";
    }

    @GetMapping("/usuarios/new")
    public String createUsuarioForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuarios-create";
    }

    @PostMapping("/usuarios/new")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {

        usuarioService.saveUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{usuarioId}/edit")
    public String editUsuarioForm(@PathVariable("usuarioId") Long usuarioId, Model model) {
        UsuarioDto usuarioDto = usuarioService.findUsuarioById(usuarioId);
        model.addAttribute("usuarioDto", usuarioDto);
        return "usuarios-edit";
    }

    @PostMapping("/usuarios/{usuarioId}/edit")
    public String updateUsuario(@PathVariable("usuarioId") Long usuarioId,
                                @Valid @ModelAttribute("usuario") UsuarioDto usuarioDto,
                                BindingResult result,
                                Model model){

        if (result.hasErrors()) {
            usuarioDto = usuarioService.findUsuarioById(usuarioId);
            model.addAttribute("usuarioDto", usuarioDto);
            return "usuarios-edit";
        }
        usuarioDto.setId(usuarioId);
        usuarioService.updateUsuario(usuarioDto);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{usuarioId}/delete")
    public String deleteUsuario(@PathVariable("usuarioId") Long usuarioId) {
        usuarioService.delete(usuarioId);
        return "redirect:/usuarios";
    }
}

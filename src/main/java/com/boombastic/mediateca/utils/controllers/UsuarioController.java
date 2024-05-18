package com.boombastic.mediateca.utils.controllers;

import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}

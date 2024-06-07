package com.boombastic.mediateca.utils.controllers;

import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private UsuarioService usuarioService;
    @Autowired
    public LoginController(UsuarioService usuarioService) {usuarioService = usuarioService;}

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}

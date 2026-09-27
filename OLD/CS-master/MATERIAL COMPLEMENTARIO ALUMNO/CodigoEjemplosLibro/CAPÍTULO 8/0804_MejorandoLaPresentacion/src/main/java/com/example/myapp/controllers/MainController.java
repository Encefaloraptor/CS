package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.myapp.services.UsuarioService;

@Controller
public class MainController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping({ "/", "/home" })
    public String showHome() {
        return "indexView";
    }

    @GetMapping("/privado")
    public String showPrivate() {
        return "privadoView";
    }

    @GetMapping("/accessError")
    public String showAccessErrorPage() {
        return "accessErrorPage";
    }

}

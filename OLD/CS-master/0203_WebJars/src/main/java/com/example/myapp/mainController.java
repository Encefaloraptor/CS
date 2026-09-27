package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/palmares")
    public String palmares() {
        return "palmares";
    }

    @GetMapping("/galeriaFotos")
    public String galeriaFotos() {
        return "galeriaFotos";
    }

    @GetMapping("/enlacesExternos")
    public String enlacesExternos() {
        return "enlacesExternos";
    }
}

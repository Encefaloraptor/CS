package com.example.myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    long[] votos = {0L, 0L, 0L};


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("votosFoto", votos);
        model.addAttribute("txtErr", null);  
        return "homeView";  
    }

    @GetMapping("/voto")
    public String votar(@RequestParam("foto") Integer foto, Model model) {
        if (foto < 0 || foto >= votos.length) {
            model.addAttribute("votosFoto", votos);
            model.addAttribute("txtErr", "Voto inválido");
            return "homeView";
        }
        votos[foto]++;
        return "redirect:/";  
    }
}
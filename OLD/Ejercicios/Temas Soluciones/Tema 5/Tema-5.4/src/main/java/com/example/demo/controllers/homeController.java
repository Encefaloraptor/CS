package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class homeController {
    @GetMapping({"/", "/home", "/index", "/Celta"})
    public String homePage(@RequestParam Optional<String >nombre,Model model) {
        if(nombre == null){
            model.addAttribute("team", "Bienvenido XXX a nuestra erb.");
        }else{
            model.addAttribute("team", "Bienvenido " + nombre.orElse("XXX") + " a nuestra Web");
        }
        model.addAttribute("date", "©" + LocalDate.now().getYear());
        return "index";
    }
}
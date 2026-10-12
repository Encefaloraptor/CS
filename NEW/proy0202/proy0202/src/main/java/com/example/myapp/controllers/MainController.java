package com.example.myapp.controllers;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //http://localhost:9090/
    //http://localhost:9090/index
    //http://localhost:9090/home
    @GetMapping({ "/", "/index", "/home" })
    public String showHome(Model model) {
        model.addAttribute("anno", LocalDate.now().getYear());
        return "indexView";
    }

    //http://localhost:9090/palmares
    @GetMapping("/palmares")
    public String showPalmares(Model model) {
        HashSet<String> titulos = new HashSet<>();
        titulos.add("Campeonatos de Liga: 1 (1999-2000)");
        titulos.add("Subcampeonatos de Liga: 5");
        titulos.add("Copas del Rey: 2 (1995 y 2002)");
        titulos.add("Copas de España: 1 (1912)");
        titulos.add("Supercopas de España: 3 (1995, 2000 y 2002)");
        titulos.add("Semi finalista UEFA Champions League (2003- 2004)");
        titulos.add("Cuarto finalista UEFA Champions League (2000- 2001 y 2001- 2002)");
        model.addAttribute("titulos", titulos);
        return "palmaresView";
    }

    //http://localhost:9090/galeria-fotos
    @GetMapping("/galeria-fotos")
    public String showGaleriaFotos() {
        return "photogalleryView";
    }

    // ESTE MAPPING SE GESTIONA MEDIANTE LA CLASE WebMvcConfig.java
    // @GetMapping("/enlaces")
    // public String showEnlaces() {
    // return "linksView";
    // }
}

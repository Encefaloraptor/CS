package com.paulacollazo.estaticas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;




@Controller

@RequestMapping("/datos")
public class paginaController {
     @GetMapping("/titulos")
    public String getTitulos(Model model) {
        List<String> listaTitulos =
                new ArrayList<>(Arrays.asList("Segunda División (3): 1935/36, 1981/82, 1991/92", "Segunda División B (1): 1980/81"));
        model.addAttribute("listaTitulos", listaTitulos );
        return "celta";
    }

    @GetMapping("/fotos")
    public String getFotos() {
        
        return "galeria-fotos";
    }

    @GetMapping("/enlaces")
    public String newItem(Model model) {
            List<String> enlaces =
                new ArrayList<>(Arrays.asList("https://rccelta.es/", "https://es.wikipedia.org/wiki/Real_Club_Celta_de_Vigo", "https://www.laliga.com/es-ES/clubes/celta", "https://twitter.com/RCCelta", "https://www.facebook.com/RealCelta", "https://www.instagram.com/rccelta/", "https://www.youtube.com/user/RealCeltaTV"));
        model.addAttribute("miUrl", enlaces );
        
        return "enlaces-externos";
    }


}



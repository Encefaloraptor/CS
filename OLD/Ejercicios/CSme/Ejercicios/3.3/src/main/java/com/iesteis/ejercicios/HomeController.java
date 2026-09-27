package com.iesteis.ejercicios;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.Optional;



@Controller                     // anotación controlador
public class HomeController {

    @GetMapping({"/home", "/", "/index"})            // ruta a la que responde por GET
    public String showHome(@RequestParam Optional <String> nombre, Model model) {
        LocalDate date = LocalDate.now();
        Integer year = date.getYear();
        model.addAttribute("year", year);
        model.addAttribute("nombre", nombre.orElse(""));
        return "indexView";     // vista que devuelve
    }

    @GetMapping("/palmares")
    public String irAlPalmares(Model model) {
        ArrayList<String> palmares = new ArrayList<>();
        palmares.add("Copa del Rey 84-85");
        palmares.add("Liga Española 87-88");
        palmares.add("Mundial de clubes 90-91");
        palmares.add("Copa Danone 95-96");
        palmares.add("Olimpiadas de invierno 98-99");
        palmares.add("Champions League 02-03");
        palmares.add("Nobel de la Paz 10-11");
        model.addAttribute("palmares", palmares);
        return "palmares";
    }
    
    @GetMapping("/galeria-fotos")
    public String irAGaleria() {
        return "galeria-fotos";
    }

    @GetMapping("/enlaces-externos")
    public String irAEnlaces() {
        return "enlaces-externos";
    }

    
}

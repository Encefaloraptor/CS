package com.ejercicio35;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping({"/", "/index", "/home"})
    public String showHome(@RequestParam(value = "nombre", required = false) String nombre,Model model){
        model.addAttribute("anno", LocalDate.now().getYear());
        model.addAttribute("nombreUsuario", nombre == null ? "" : nombre.toUpperCase());
        return "indexView";
    }


}



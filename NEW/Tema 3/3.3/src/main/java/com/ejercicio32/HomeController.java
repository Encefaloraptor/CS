package com.ejercicio32;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping({"/", "/index", "/home"})
    public String showHome(Model model){
        model.addAttribute("anno", LocalDate.now().getYear());
        return "indexView";
    }

    @GetMapping("/funnycats")
    public String showCats(){
        return "funnycatsView";
    }

    @GetMapping("/galeria")
    public String showGaleria(){
        return "galeriaView";
    }

    @GetMapping("/enlaces")
    public String showEnlaces(){
        return "enlacesView";
    }

    @GetMapping("/usuario")
    public String usuarioForm(@RequestParam(value = "nombre", required = false) String nombre, Model model) {
        if (nombre != null ) {
            model.addAttribute("nombreUsuario", nombre.toUpperCase());
            return "usuarioView";
        }
        return "usuarioFormView";
    }
    
    @GetMapping("/usuario/{nombre}")
    public String showUsuario(Model model, @PathVariable String nombre) {
        return "usuarioView";
    }
}



package com.ejercicio2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(){
        return "index";
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
}

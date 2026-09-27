package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                     // anotación controlador
public class HomeController {
    @GetMapping("/")            // ruta a la que responde por GET
    public String showHome() {
        return "indexView";     // vista que devuelve
    }
}

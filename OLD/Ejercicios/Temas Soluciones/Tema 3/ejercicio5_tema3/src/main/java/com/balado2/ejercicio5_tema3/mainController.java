package com.balado2.ejercicio5_tema3;


import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class mainController {
    @GetMapping("/")
    public String ShowHome(Model model) {
        LocalDateTime fecha = LocalDateTime.now();
        model.addAttribute("fecha", fecha);
        return "index";
    }
    
}

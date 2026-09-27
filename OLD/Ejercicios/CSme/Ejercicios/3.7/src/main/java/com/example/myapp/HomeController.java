package com.example.myapp;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("fechaActual", LocalDate.now());
        return "homeView";
    }
}

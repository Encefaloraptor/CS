package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.myapp.services.SumaService;

@Controller
public class SumaController {

    @Autowired
    private SumaService sumaService;

    @GetMapping("/suma/{numX}/{numY}")
    public String showSuma(@PathVariable Integer numX, @PathVariable Integer numY, Model model) {
        Integer result = sumaService.suma(numX, numY);
        model.addAttribute("resultado", result);
        return "resultSumaView";
    }

    @GetMapping("/")
    public String showHome() {
        return "indexView";
    }

}

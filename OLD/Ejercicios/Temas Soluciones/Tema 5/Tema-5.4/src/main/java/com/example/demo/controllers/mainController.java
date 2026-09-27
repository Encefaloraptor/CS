package com.example.demo.controllers;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/Celta")
public class mainController {
    @GetMapping("/palmares")
    public String titlesPage(Model model) {
        List<String> titulos = new ArrayList<String>();
        titulos.add("Copa de España: Subcampeones en 1947-48, 1993-34, 200-01");
        titulos.add("Segunda división: Títulos en 1935-36, 1981-82, 1991-92. Subcampeonatos en: 1959-60, 1960-61, 1965-66, 1968-69, 1975-76, 2004-05, 2011-12");
        titulos.add("Segunda División B: 1980-81");
        titulos.add("Tercera Divsión: 1930-31");
        model.addAttribute("palmares", titulos);
        return "palmares";
    }
}
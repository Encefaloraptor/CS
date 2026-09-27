package com.example.myapp;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome(
            @RequestParam(name = "profesor", required = false) String nombreProf,
            @RequestParam(name = "modulo", required = false, defaultValue = "X") String nombreModulo, Model model) {
        if (nombreProf == null)
            nombreProf = "X";
        model.addAttribute("profe", nombreProf);
        model.addAttribute("modul", nombreModulo);
        return "indexView";
    }

    @GetMapping("/v2")
    public String showHomeV2(
            @RequestParam(required = false) String profesor,
            @RequestParam(required = false, defaultValue = "X") String modulo,
            Model model) {
        if (profesor == null)
            profesor = "X";
        model.addAttribute("profe", profesor);
        model.addAttribute("modul", modulo);
        return "indexView";
    }

    @GetMapping("/v3")
    public String showHome(
            @RequestParam Optional<String> profesor,
            @RequestParam Optional<String> modulo, Model model) {
        model.addAttribute("profe", profesor.orElse("X"));
        model.addAttribute("modul", modulo.orElse("X"));
        return "indexView";
    }

    @GetMapping("/buscaprofe/{nombreProfesor}")
    public String showProfe(@PathVariable String nombreProfesor,
            Model model) {
        model.addAttribute("profe", nombreProfesor.toUpperCase());
        return "profeView";
    }
    @GetMapping("/buscaprofe/")
    public String showProfeErr(Model model) {
        model.addAttribute("profe", "error: falta nombre de profesor en path");
        return "profeView";
    }

}

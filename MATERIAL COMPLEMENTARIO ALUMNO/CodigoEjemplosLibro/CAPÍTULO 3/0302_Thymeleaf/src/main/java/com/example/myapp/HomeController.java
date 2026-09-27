package com.example.myapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // anotación controlador
public class HomeController {

    @GetMapping({ "/", "/home" })
    public String showHome(Model model) {
        String ciudad = "A Coruña";
        model.addAttribute("city", ciudad);
        return "homeView";
    }

    @GetMapping("/productos")
    public String showProducts(Model model) {
        List<String> listaProductos = new ArrayList<>(Arrays.asList("Pr1", "Pr2", "Pr3"));
        model.addAttribute("listaProd", listaProductos);
        return "productsView";
    }

    @GetMapping("/thymeleafExamples")
    public String showThymeleafExamples(Model model) {
        model.addAttribute("city", "A Coruña");
        model.addAttribute("fecha", LocalDate.now());
        model.addAttribute("result", 100);
        model.addAttribute("edad", 20);
        model.addAttribute("registrado", true);
        model.addAttribute("activo", false);
        
        List<Empleado> listaEmpl = new ArrayList<>();
        listaEmpl.add(new Empleado (1L,"Juan López", "jl@mail.com",40000.0));
        listaEmpl.add(new Empleado (2L,"Eva Pérez", "ep@mail.com",50000.0));
        model.addAttribute("listaEmpleados", listaEmpl);

        model.addAttribute("numero", 1000);         
        
        return "thymeleafExamplesView";
    }
}

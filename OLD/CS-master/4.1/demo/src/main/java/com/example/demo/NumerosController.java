package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NumerosController {

    @Autowired
    private NumerosService numerosService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("cantidadTotal", numerosService.getCantidad());
        model.addAttribute("listaNumeros", numerosService.getLista());
        return "listView";
    }

    @GetMapping("/new")
    public String showNew() {
        numerosService.addNumeroAleatorio();
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id) {
        numerosService.eliminarNumero(id);
        return "redirect:/";
    }
}

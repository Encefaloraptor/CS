package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.myapp.services.VehiculoService;

@Controller
public class VehiculoController {

    @Autowired
    public VehiculoService vehiculoService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("listaCoches", vehiculoService.obtenerTodosCoches());
        model.addAttribute("listaMotos", vehiculoService.obtenerTodosMotos());
        return "listView";
    }
}

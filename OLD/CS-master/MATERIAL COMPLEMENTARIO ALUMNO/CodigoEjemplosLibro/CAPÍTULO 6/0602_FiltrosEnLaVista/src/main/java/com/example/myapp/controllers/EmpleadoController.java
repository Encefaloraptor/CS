package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;
import com.example.myapp.services.EmpleadoService;

@Controller
public class EmpleadoController {

    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("findForm", new Empleado());
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        return "listView";
    }

    @PostMapping("/findByName")
    public String showFindByNameSubmit(Empleado empleadoForm, Model model) {
        model.addAttribute("listaEmpleados",
                empleadoService.buscarPorNombre(empleadoForm.getNombre()));
        model.addAttribute("findForm", empleadoForm);
        return "listView";
    }

    @GetMapping("/findByGenero/{genero}")
    public String showFindByGen(@PathVariable Genero genero, Model model) {
        model.addAttribute("listaEmpleados", empleadoService.buscarPorGenero(genero));
        model.addAttribute("findForm", new Empleado());
        model.addAttribute("generoSeleccionado", genero);
        return "listView";
    }

}

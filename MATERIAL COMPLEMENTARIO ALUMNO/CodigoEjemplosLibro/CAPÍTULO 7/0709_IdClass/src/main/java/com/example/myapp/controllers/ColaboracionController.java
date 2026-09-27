package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.domain.Colaboracion;
import com.example.myapp.domain.ColaboracionId;
import com.example.myapp.services.ColaboracionService;
import com.example.myapp.services.EmpleadoService;
import com.example.myapp.services.ProyectoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/colaboracion")
public class ColaboracionController {

    @Autowired
    public ColaboracionService colaboracionService;

    @Autowired
    public EmpleadoService empleadoService;

    @Autowired
    public ProyectoService proyectoService;

    @GetMapping("/emp/{id}") // lista de proyectos de un empleado
    public String showProyectsByEmpl(@PathVariable long id, Model model) {
        model.addAttribute("listaColaboracion", colaboracionService.obtenerPorEmpleadoId(id));
        model.addAttribute("empleado", empleadoService.obtenerPorId(id));
        return "colaboracion/empListView";

    }

    @GetMapping("/pro/{id}") // lista de empleados de un proyecto
    public String showEmplbyProyect(@PathVariable long id, Model model) {
        model.addAttribute("listaColaboracion", colaboracionService.obtenerPorProyectoId(id));
        model.addAttribute("proyecto", proyectoService.obtenerPorId(id));
        return "colaboracion/proListView";
    }

    @GetMapping("/delete/{idEmpl}/{idPro}")
    public String showDelete(@PathVariable Long idEmpl, @PathVariable Long idPro) {
        ColaboracionId colaboracionId = new ColaboracionId(idEmpl, idPro);
        colaboracionService.borrar(colaboracionService.obtenerPorId(colaboracionId));
        return "redirect:/";
    }

    @GetMapping("/new")
    public String showNewColab(Model model) {
        model.addAttribute("colaboracionForm", new Colaboracion());
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        model.addAttribute("listaProyectos", proyectoService.obtenerTodos());
        return "colaboracion/newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewColabSubmit(@Valid Colaboracion nuevaColaboracion,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors())
            colaboracionService.añadir(nuevaColaboracion);
        return "redirect:/";
    }
}

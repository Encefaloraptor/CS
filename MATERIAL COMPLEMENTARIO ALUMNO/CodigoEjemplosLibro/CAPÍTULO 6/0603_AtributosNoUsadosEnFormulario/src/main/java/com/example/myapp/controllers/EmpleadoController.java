package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.domain.Empleado;
import com.example.myapp.services.EmpleadoService;

import jakarta.validation.Valid;

@Controller
public class EmpleadoController {

    @Autowired
    public EmpleadoService empleadoService;

    private String txtMsg;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        if (txtMsg != null) {
            model.addAttribute("msg", txtMsg);
            txtMsg = null;
        }
        return "listView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null) {
            txtMsg = "Empleado no encontrado";
            return "redirect:/";
        }
        model.addAttribute("empleado", empleado);
        return "listOneView";

    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        // el commandobject del formulario es una instancia de empleado vacia
        model.addAttribute("empleadoForm", new Empleado());
        return "newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Empleado empleadoForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            txtMsg = "Error en formulario";
            return "redirect:/";
        }
        empleadoService.añadir(empleadoForm);
        txtMsg = "Operación realizada con éxito";
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null) {
            txtMsg = "Empleado no encontrado";
            return "redirect:/";
        }
        model.addAttribute("empleadoForm", empleado);
        return "editFormView";
    }

    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Empleado empleadoForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            txtMsg = "Error en formulario";
            return "redirect:/";
        }
        Empleado empleado = empleadoService.editar(empleadoForm);
        if (empleado == null)
            txtMsg = "Empleado no encontrado";
        else
            txtMsg = "Operación realizada con éxito";
        return "redirect:/";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        txtMsg = "Operación realizada con éxito";
        return "redirect:/";
    }
}

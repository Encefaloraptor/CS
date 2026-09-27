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
    
    @GetMapping("/nuevo")
    public String showNew(Model model) {
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
        try {
            empleadoService.añadir(empleadoForm);
            txtMsg = "Operación realizada con éxito";
        } catch (RuntimeException e) {
            txtMsg = e.getMessage();
        }
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        try {
            Empleado empleado = empleadoService.obtenerPorId(id);
            model.addAttribute("empleadoForm", empleado);
            return "editFormView";
        } catch (RuntimeException e) {
            txtMsg = e.getMessage();
            return "redirect:/";
        }
    }

    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Empleado empleadoForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            txtMsg = "Error en formulario";
            return "redirect:/";
        }
        try {
            empleadoService.editar(empleadoForm);
            txtMsg = "Operación realizada con éxito";
        } catch (RuntimeException e) {
            txtMsg = e.getMessage();
        }
        return "redirect:/";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        txtMsg = "Operación realizada con éxito";
        return "redirect:/";
    }

    @GetMapping("/accessError")
    public String showAccessErrorPage() {
        return "accessErrorPage";
    }

}

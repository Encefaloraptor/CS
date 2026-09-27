package com.example.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;
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
        try {
            model.addAttribute("empleado", empleadoService.obtenerPorId(id));
            return "listOneView";
        } catch (RuntimeException e) {
            txtMsg = e.getMessage();
            return "redirect:/";
        }
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

    @GetMapping("/listado1/{salario}")
    public String showListado1(@PathVariable Double salario, Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadosSalarioMayor(salario);
        model.addAttribute("tituloListado", "Empleados salario mayor que " +
                salario.toString());
        model.addAttribute("listaEmpleados", empleados);
        return "listadosView";
    }

    @GetMapping("/listado2")
    public String showListado2(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
        model.addAttribute("tituloListado", "Empleados salario mayor que la media");
        model.addAttribute("listaEmpleados", empleados);
        return "listadosView";
    }

    @GetMapping("/sumaSalario/{genero}")
    public String showListado3(@PathVariable Genero genero, Model model) {
        model.addAttribute("sumaSalario", empleadoService.obtenerSumaSalariosPorGenero(genero));
        model.addAttribute("genero", genero);
        return "sumaSalariosView";
    }

}

package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.domain.Departamento;
import com.example.myapp.services.DepartamentoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/depto")
public class DepartamentoController {

    @Autowired
    public DepartamentoService departamentoService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        return "departamento/listView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("departamentoForm", new Departamento());
        return "departamento/newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("departamentoForm") Departamento nuevoDepartamento,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) 
                    nuevoDepartamento = departamentoService.añadir(nuevoDepartamento);
        return "redirect:/depto/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento != null) {
            model.addAttribute("departamentoForm", departamento);
            return "departamento/editFormView";
        } else {
            return "redirect:/depto/list";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid @ModelAttribute("departamentoForm") Departamento departamento,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) 
                    departamentoService.editar(departamento);
        return "redirect:/depto/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        departamentoService.borrar(departamentoService.obtenerPorId(id));
        return "redirect:/depto/list";
    }
}

package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.domain.Nomina;
import com.example.myapp.services.EmpleadoService;
import com.example.myapp.services.NominaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/nominas")
public class NominaController {

    @Autowired
    public NominaService nominaService;

    @Autowired
    public EmpleadoService empleadoService;

    private String txtMsg;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaNominas", nominaService.obtenerTodos());
        if (txtMsg != null) {
            model.addAttribute("msg", txtMsg);
            txtMsg = null;
        }
        return "nomina/listView";
    }

    @GetMapping("/{id}")
    public String showNominasEmpleado(@PathVariable Long id, Model model) {
        model.addAttribute("listaNominas", empleadoService.obtenerNominas(id));
        return "nomina/listView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("nominaForm", new Nomina());
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        return "nomina/newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Nomina nominaForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/nominas/new";
        nominaService.añadir(nominaForm);
        return "redirect:/nominas/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Nomina nomina = nominaService.obtenerPorId(id);
        if (nomina != null) {
            model.addAttribute("nominaForm", nomina);
            model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
            return "nomina/editFormView";
        } else {
            return "redirect:/nominas/list";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid Nomina nominaForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            nominaService.editar(nominaForm);
        else 
            txtMsg = "Error en formulario";
        return "redirect:/nominas/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        nominaService.borrar(id);
        return "redirect:/nominas/list";
    }
}

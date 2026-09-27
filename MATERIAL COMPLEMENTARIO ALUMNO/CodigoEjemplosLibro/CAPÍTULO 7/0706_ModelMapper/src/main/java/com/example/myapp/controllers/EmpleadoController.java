package com.example.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myapp.domain.Empleado;
import com.example.myapp.dto.EmpleadoDTO;
import com.example.myapp.services.DepartamentoService;
import com.example.myapp.services.EmpleadoService;

import jakarta.validation.Valid;

@Controller
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;
    @Autowired
    public DepartamentoService departamentoService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        List<EmpleadoDTO> listaDTO = empleadoService.convertEmpleadoToDto(listaEmpleados);
        model.addAttribute("listaEmpleados", listaDTO);
        return "empleado/listView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable Long id, Model model) {
        model.addAttribute("empleado", empleadoService.obtenerPorId(id));
        return "empleado/listOneView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("empleadoForm", new Empleado());
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());

        return "empleado/newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("empleadoForm") Empleado nuevoEmpleado,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors())
            nuevoEmpleado = empleadoService.añadir(nuevoEmpleado);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado != null) {
            model.addAttribute("empleadoForm", empleado);
            model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
            return "empleado/editFormView";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid @ModelAttribute("empleadoForm") Empleado empleado,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors())
            empleadoService.editar(empleado);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        return "redirect:/list";
    }
}

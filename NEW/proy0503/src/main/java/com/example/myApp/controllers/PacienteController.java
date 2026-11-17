package com.example.myApp.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.myApp.domain.Paciente;
import com.example.myApp.dto.NewPacienteDTO;
import com.example.myApp.services.PacienteService;

@Controller
public class PacienteController {

    @Autowired
    public PacienteService pacienteService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("listaPacientes", pacienteService.findAll());
        model.addAttribute("factura", 0);
        return "pacientesListView";
    }

    @GetMapping("/newPaciente")
    public String showNew(Model model) {
        model.addAttribute("newPacienteDTO", new NewPacienteDTO());
        return "pacienteNewView";
    }

    @PostMapping("/newPaciente/submit")
    // public String showNewSubmit(@Valid @ModelAttribute("newPacienteDTO")
    // NewPacienteDTO newPacienteDTO,
    public String showNewSubmit(@Valid @ModelAttribute NewPacienteDTO newPacienteDTO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "pacienteNewView";
        }
        Paciente nuevoPaciente = pacienteService.buildPaciente(newPacienteDTO);
        pacienteService.add(nuevoPaciente);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String showDelete(Model model) {
        Paciente paciente = pacienteService.getFirst();
        double factura = 0;
        if (paciente != null) {
            factura = pacienteService.facturar(paciente);
            pacienteService.deleteFirst();
        }
        model.addAttribute("listaPacientes", pacienteService.findAll());
        model.addAttribute("factura", factura);
        return "pacientesListView";

    }
}

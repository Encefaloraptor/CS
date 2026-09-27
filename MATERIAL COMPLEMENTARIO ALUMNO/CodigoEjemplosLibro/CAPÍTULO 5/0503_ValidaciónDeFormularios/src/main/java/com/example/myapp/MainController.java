package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class MainController {
    @GetMapping({ "/", "/myForm" })
    public String showForm(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "formView";
    }

    @PostMapping("/myForm/submit")
    public String showMyformSubmit(@Valid @ModelAttribute("formInfo") FormInfo formInfo, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors())
            return "formView";
        model.addAttribute("datosProcesados", formInfo.toString());
        return "formularioProcesadoView";

    }
}
package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping({"/","/myForm"})
    public String showForm(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "formView";
    }

    @PostMapping("/myForm/submit")
                            //recibe formulario lleno
    public String showMyformSubmit(FormInfo formInfo, Model model)2 {
        formInfo.setNombre(formInfo.getNombre().toUpperCase());
        model.addAttribute("formInfo", formInfo);
        return "formSubmitView";
    }
}
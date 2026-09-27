package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping({"/","/myForm"})
    public String showForm(Model model) {
        List <Provincia> listaProvincias = new ArrayList<>();
        listaProvincias.add(new Provincia(1L,"A Coruña"));listaProvincias.add(new Provincia(2L,"Lugo"));
        listaProvincias.add(new Provincia(3L,"Pontevedra"));listaProvincias.add(new Provincia(4L,"Ourense"));      
        
        model.addAttribute("formInfo", new FormInfo());
        model.addAttribute("listaProvincias", listaProvincias);

        return "formView";
    }

    @PostMapping("/myForm/submit")
    public String showMyformSubmit(FormInfo formInfo, Model model) {
        formInfo.setNombre(formInfo.getNombre().toUpperCase());
        model.addAttribute("datosRecibidos", formInfo.toString());
        return "formSubmitView";
    }


    
}
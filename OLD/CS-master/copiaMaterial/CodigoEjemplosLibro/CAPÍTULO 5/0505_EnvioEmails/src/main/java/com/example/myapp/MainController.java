package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String showHome(@RequestParam(required = false) String err, Model model) {
        model.addAttribute("formInfo", new FormInfo());
        if (err != null)
            model.addAttribute("msg", "Error inesperado");
        return "indexView";
    }

    @PostMapping("/formsubmit")
    public String showContacta(FormInfo formInfo, Model model, @RequestParam MultipartFile file) {
        String nuevoNombreFichero = mainService.storeFile(file, formInfo);
        if (nuevoNombreFichero == null)
            return "redirect:/?err=1";
        boolean envioEmail = mainService.enviarEmail("destination@mail.com",
                formInfo.getAsunto(),
                "Mensaje de:" + formInfo.getNombre() + "[" + formInfo.getTelefono() + "]",
                nuevoNombreFichero);
        if (!envioEmail)
            return "redirect:/?err=1";
        return "mailSentView";
    }
}

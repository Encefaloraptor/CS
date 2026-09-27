package com.example.paises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
    @Autowired
    @Qualifier("PaisesService")
    private IPaisesService ps;

    @GetMapping({""})
    public String goPaises(Model model) {
        return "redirect:/paises";
    }

    @GetMapping({"/paises"})
    public String showPaises(Model model) {
        model.addAttribute("paises", ps.getPaises());
        if(model.getAttribute("pais") == null)
            model.addAttribute("pais", new Pais());

        return "index";
    }

    @PostMapping("/submit")
    public RedirectView showFormSubmitView(Pais pais, RedirectAttributes attributes) {
        try {
            attributes.addFlashAttribute("pais", ps.getPais(pais.getNombre()));
            attributes.addFlashAttribute("found", true);
        } catch (PaisNotFoundException e) {
        }

        return new RedirectView("/paises");
    }
}

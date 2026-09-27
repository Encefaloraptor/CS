package com.example.myapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myapp.services.MathService;

@Controller
public class MathController {

    @Autowired
    private MathService mathService;
    private String txtError;

    @GetMapping("/calcularHipotenusa/{cat1}/{cat2}")
    public String showHipot(@PathVariable Double cat1, @PathVariable Double cat2, Model model) {
        try {
            model.addAttribute("resultado",
                    mathService.calcularHipotenusa(cat1, cat2));
            return "resultadoView";
        }
        // OPCIÓN 1 : Vista de error con Model:
        // catch (RuntimeException ex) {
        // model.addAttribute("txtError", ex.getMessage());
        // return "errorView";
        // }
        // OPCIÓN 2 : redirect a indexView con parámetro de error:
        // catch (RuntimeException ex) {
        // return "redirect:/home?err=1";
        // }
        // OPCION 3 : redirect a indexView con valriable global txtError
        catch (RuntimeException ex) {
            txtError = ex.getMessage();
            return "redirect:/home";
        }
    }

    @GetMapping({ "/", "/home" })
    public String showHome(@RequestParam(required = false) Integer err, Model model) {
        // PARA OPCION 2:
        // if (err != null)
        // model.addAttribute("txtErr", "Error en parámetros");
        //
        // PARA OPCION 3:
        if (txtError != null) {
            model.addAttribute("txtErr", txtError);
            txtError = null; // vacía la variable para usarla de nuevo
        }
        return "indexView";
    }

}

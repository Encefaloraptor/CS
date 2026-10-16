package com.example.ejercicios_tema_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ejercicios_tema_2.service.CalculosServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculos")
public class MatematicasController {

    @Autowired
    CalculosServiceImpl calcServ;

    @GetMapping("/home")
    public String getHomePage() {
        return "calculos";
    }

    @GetMapping("/hipotenusa/{cat1}/{cat2}")
    public String getHipotenusa(@PathVariable String cat1 , @PathVariable String cat2, Model model,
            RedirectAttributes redirectAttrs) {
        try {
            String output = "La hipotenusa es " + calcServ.hipotenusa(cat1, cat2);
            redirectAttrs.addFlashAttribute("resultado", output);

        } catch (Exception ex) {
            showErrMessage(ex, redirectAttrs);
        }

        return "redirect:/calculos/home";
    }

    @GetMapping("/primo")
    public String getPrimo(@RequestParam Integer num, RedirectAttributes redirectAttrs) {
        try {
            String output = "¿Es primo el número " + num + "? " + calcServ.isPrimo(num);
            redirectAttrs.addFlashAttribute("resultado", output);
        } catch (Exception ex) {
            showErrMessage(ex, redirectAttrs);
        }
        return "redirect:/calculos/home";
    }

    @GetMapping("/divisores/{num}")
    public String getDivisores(@PathVariable Integer num, RedirectAttributes redirectAttrs) {
        try {
            String output = "Divisores: " + calcServ.divisores(num).toString();
            redirectAttrs.addFlashAttribute("resultado", output);
        } catch (Exception ex) {
            showErrMessage(ex, redirectAttrs);
        }
        return "redirect:/calculos/home";
    }

    private void showErrMessage(Exception ex, RedirectAttributes redirectAttrs) {
        if (ex instanceof RuntimeException) {
            redirectAttrs.addFlashAttribute("txtErr", ex.getMessage());
        } else if (ex instanceof NumberFormatException) {
            showErrMessage(ex, redirectAttrs);
        }
    }
}
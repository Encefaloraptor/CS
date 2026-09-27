package com.example.ejercicios_tema_2.controller;

import com.example.ejercicios_tema_2.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/calculator")
public class CalculadoraController {

    @Autowired
    CalculadoraService calculadoraService;


    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("firstNumber", calculadoraService.getFirstNumber());
        model.addAttribute("secondNumber", calculadoraService.getSecondNumber());
        model.addAttribute("result", calculadoraService.getResult());
        return "calculator";
    }

    @GetMapping("/insert-number/{number}")
    public String insertNumber(@PathVariable Integer number) {
        calculadoraService.insertNumber(number);
        return "redirect:/calculator/home";
    }

    @GetMapping("/resultado")
    public String getResultado() {
        calculadoraService.calculateResult();
        return "redirect:/calculator/home";
    }

    @GetMapping("/cambiar-operando/{operacion}")
    public String cambiarOperando(@PathVariable String operacion) {
        calculadoraService.selectOperation(operacion);
        return "redirect:/calculator/home";
    }

    @GetMapping("/limpiar")
    public String limpiar() {
        calculadoraService.clean();
        return "redirect:/calculator/home";
    }
}
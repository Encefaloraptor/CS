package com.demo.myapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.myapp.services.CalculosService;

@Controller
public class CalculosController {
//Autowireamos el servicio para poder usar sus métodos
    @Autowired
    CalculosService calculosService;

    @GetMapping("/")
    public String showHome() {
        return "indexView";
    }

    @GetMapping("/calculos/primo")
    //Debo indicar Optional para que Spring no me de error si no paso el parámetro y poder usar el método isEmpty()
    public String showPrimo(@RequestParam() Optional<Integer> numero, Model model) {
        boolean res;
        if (numero.isEmpty()) {
            model.addAttribute("errMsg", "Debe pasar un número como parámetro");
            return "errorView";
        }
        res = calculosService.esPrimo(numero.get());
        model.addAttribute("result", res);
        return "esPrimoView";
    }

    @GetMapping("/calculos/hipotenusa/{catX}/{catY}")
    public String showHipotenusa(@PathVariable Double catX, @PathVariable Double catY, Model model) {
        try {
            model.addAttribute("hipotenusa", calculosService.hipotenusa(catX, catY));
            return "hipotView";
        } catch (RuntimeException e) {
            model.addAttribute("errMsg", e.getMessage());
            return "errorView";
        }
    }

    @GetMapping("/calculos/divisores/{num}")
    public String showDivisores(@PathVariable Integer num, Model model) {
        if (num < 1) { // este control puede ser en el servicio...aquí iría try-catch
            model.addAttribute("errMsg", "El número debe ser positivo");
            return "errorView";
        }
        List<Integer> lista = calculosService.divisores(num);
        model.addAttribute("numeros", lista);
        return "divisorView";
    }

}

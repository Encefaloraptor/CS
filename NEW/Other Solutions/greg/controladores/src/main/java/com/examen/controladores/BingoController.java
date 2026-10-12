package com.examen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class BingoController {

    @Autowired
    private bingoService bingoSrvc;

    @GetMapping({"", "/"})
    public String showCarton(
        @RequestParam(required = false) Integer numeros,
        @RequestParam(required = false) Integer mayores50,
        Model model) {

        try {
            model.addAttribute("numerosOK", bingoSrvc.probaNumeros(numeros));
            model.addAttribute("mayores50OK", bingoSrvc.probaMayores50(numeros, mayores50));

            var listaCarton = bingoSrvc.createCarton(numeros, mayores50);
            model.addAttribute("listaCarton", listaCarton);
            model.addAttribute("tamano", listaCarton.size());

            model.addAttribute("numeros", numeros);
            model.addAttribute("mayores50", mayores50);

        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "errorView";
        }
        return "cartonView";
    }

    @GetMapping("delete/{numero}")
    public String deleteNumero(
        @PathVariable int numero,
        @RequestParam int numeros,
        @RequestParam int mayores50) {

        
        return "redirect:/?numeros=" + numeros + "&mayores50=" + mayores50;
    }

    @GetMapping("nuevo")
    public String nuevaPartida(
        @RequestParam int numeros,
        @RequestParam int mayores50) {

        return "redirect:/?numeros=" + numeros + "&mayores50=" + mayores50;
    }
}
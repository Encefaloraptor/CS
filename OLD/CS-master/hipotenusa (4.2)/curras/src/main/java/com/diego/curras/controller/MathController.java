package com.diego.curras.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.diego.curras.services.MathService;



@Controller 
public class MathController { 
    @Autowired 
    private MathService mathService; 
    private String txtStatus=null;
    
    @GetMapping("/") 
        public String showInit(Model model) { 
        if (txtStatus != null) { 
        model.addAttribute("txtStatus",txtStatus); 
        txtStatus=null;} 
        return "indexView"; 
    } 

    @GetMapping("/calcularHipotenusa/{cat1}/{cat2}") 
        public String showHipot(@PathVariable String cat1,@PathVariable String cat2, Model model) { 
            Double cateto1, cateto2; 
            try { 
                //Pasamos los parámetros de String a Double
                cateto1 = Double.parseDouble(cat1);
                cateto2 = Double.parseDouble(cat2); 
                model.addAttribute("resultado", 
                mathService.calcularHipotenusa(cateto1, cateto2)); //otra excepción
                
                return "resultadoView"; 
                
                // Captura inválida por introducir letras/símbolos/etc en ved de números
            } catch (NumberFormatException nfe) { 
                txtStatus="Error en parámetros de entrada, al menos alguno de los catetos no es un número"; 
                return "redirect:/"; 
                
                //Capturas de Excepciones personalizadas
            } catch (Exception ex) {txtStatus=ex.getMessage(); 
                return "redirect:/";
            } 
    } 
}



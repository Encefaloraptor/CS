package com.ejercicio2.ej2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(){
        return "indexView";
    }

   @GetMapping("/palmares")
    public String showPalmares(){
        return "palmaresView";
    }

    @GetMapping("/enlaces")
    public String showEnlaces(){
        return "enlaces-externosView";
    }

    @GetMapping("/fotos")
    public String showFotos(){
        return "galeria-fotosView";
    } 
}

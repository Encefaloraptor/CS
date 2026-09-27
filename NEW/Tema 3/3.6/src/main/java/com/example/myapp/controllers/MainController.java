package com.example.myapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

 private final int[] votosFoto = {0,0,0}; 


@GetMapping("/")
    public String mostrarPágina(Model model){
        model.addAttribute("votosFoto", votosFoto);
        return "homeView";
    }


@GetMapping("/voto")
public String votación(@RequestParam(name = "foto", required = true)Integer foto ,  Model model){

votosFoto[foto]++ ;
model.addAttribute("votosFoto", votosFoto);
 return "redirect:/";

}

}
    

    


package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

private List<Integer> votosFoto = new ArrayList<>();

public MainController(){

votosFoto.add(0);
votosFoto.add(0);
votosFoto.add(0);

}

@GetMapping("/")
    public String mostrarPágina(Model model){
        model.addAttribute("votosFoto", votosFoto);
        return "homeView";
    }


@GetMapping("/voto")
public String votación(@RequestParam(name = "foto", required = false)Integer foto ,  Model model){
String textEror = null;
if (foto == null || foto < 0) {
    textEror = "voto inválido";

}else{
    votosFoto.set(foto, votosFoto.get(foto) + 1 );
}

model.addAttribute("votosFoto", votosFoto);
model.addAttribute("textError", textEror);
 return "homeView";

}

}
    

    


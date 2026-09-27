package com.paulacollazo.estaticas;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.ui.Model; 

@Controller
public class mainController {
@GetMapping("/")
    public String index( @RequestParam Optional <String> persona,
    Model model) {
        
    LocalDateTime fecha = LocalDateTime.now();

    model.addAttribute("fecha", fecha);
    model.addAttribute("persona", persona.orElse(""));

    return "index"; 
}


//     @GetMapping("/")
//     public String index( @RequestParam(required = false) String persona,
//     Model model) {

//     LocalDateTime fecha = LocalDateTime.now();

//     model.addAttribute("fecha", fecha);
//     model.addAttribute("persona", persona);

//     return "index"; 
// }
    

    // public String index(Model model) {
    // LocalDateTime fecha = LocalDateTime.now();
    // model.addAttribute("fecha", fecha);
    // return "index"; 
    

    // @GetMapping("/saludo")
    // public String index2(
    // @RequestParam(required = false, defaultValue = "") String persona, Model model){

    //     if( persona==null) persona="";
    //     model.addAttribute ("persona", persona);
    //     return "index"; 
    // }

    
}



    
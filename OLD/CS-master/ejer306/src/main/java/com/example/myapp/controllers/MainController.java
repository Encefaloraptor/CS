package com.example.myapp.controllers;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//anotamos clase como controlador
@Controller
public class MainController {
    //creamos un map para las fotos (asociación clave-valor) y lo rellenamos
    private Map<String, Integer> films = new LinkedHashMap<>();
       //Tenemos que hacer un bloque de inicialización o bien un constructor para inicializarlo 
    {
        films.put("avatar", 0);
        films.put("cadenaPerpetua", 0);
        films.put("pulpFiction", 0);
    }
    

    //mapping para mostrar index
    @GetMapping({"/", "/index"})
    public String showIndex( Model model){
        //pasamos a la vista el map films para mostrar los votos. La primera vez serán 0.
        model.addAttribute("films", films);
        return "homeView";
    }
    
    
    //Mapping para sumar voto y redirigir al mapping que muestra la vista
    @GetMapping("/voto/{film}")//OJO film tiene que ser nombrado igual en el PathVariable del método
    public String addVote(@PathVariable String film, Model model){//recibimos el valor de la pelicula en la url mediante PathVariable
        //sumamos un voto a la pelicula seleccionada
        if(films.containsKey(film)){
            films.put(film, films.get(film) + 1);
            //redirigimos al index
            return "redirect:/";
        }else {
            model.addAttribute("txtErr", "Voto inválido");
            model.addAttribute("films", films);
            return "homeView";
        }
    }

}

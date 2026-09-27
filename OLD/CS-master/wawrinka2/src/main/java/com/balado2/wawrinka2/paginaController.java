package com.balado2.wawrinka2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/informacion")
public class paginaController {

    @GetMapping("/titulos")
    public String getTitulos(Model model){
       List<String> listaTitulos =
        new ArrayList<>(Arrays.asList(
        "Grand Slam: Australian Open - 2014 (Singles)",
        "Grand Slam: Roland Garros (French Open) - 2015 (Singles)",
        "Grand Slam: US Open - 2016 (Singles)",
        "Masters 1000: Monte-Carlo Rolex Masters - 2014 (Singles)",
        "ATP 500: Rotterdam Open - 2015 (Singles)",
        "ATP 500: Japan Open (Tokyo) - 2015 (Singles)",
        "ATP 500: Dubai Tennis Championships - 2016 (Singles)",
        "ATP 250: Croatia Open (Umag) - 2006 (Singles)",
        "ATP 250: Grand Prix Hassan II (Casablanca) - 2010 (Singles)",
        "ATP 250: Maharashtra Open (Pune) - 2011 (Singles)",
        "ATP 250: Portugal Open (Estoril) - 2013 (Singles)",
        "ATP 250: Maharashtra Open (Pune) - 2014 (Singles)",
        "ATP 250: Maharashtra Open (Pune) - 2015 (Singles)",
        "ATP 250: Maharashtra Open (Pune) - 2016 (Singles)",
        "ATP 250: Geneva Open - 2016 (Singles)",
        "ATP 250: Geneva Open - 2017 (Singles)",
        "Dobles: Medalla de oro — Juegos Olímpicos Beijing - 2008, con Roger Federer (Dobles)",
        "Dobles: Maharashtra Open (dobles) - 2013, con Benoît Paire (Dobles)",
        "Dobles: Swiss Open (dobles) - 2023, con Dominic Stricker (Dobles)",
        "Equipo: Davis Cup — Campeón con Suiza - 2014 (Equipo)"
        ));
            model.addAttribute("listaTitulos", listaTitulos);
        return "titulos";
    }
    
    @GetMapping("/galeria")
    public String getGaleria(){
        return "galeria_fotos";
    }

//     @GetMapping("/referencias")
//    public String getEnlaces(){
//      return "enlaces-externos"; 
//
//
//}


    @Configuration
    public class WebMvcConfig implements WebMvcConfigurer {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/informacion/referencias").setViewName("enlaces-externos");
        }
    }




}

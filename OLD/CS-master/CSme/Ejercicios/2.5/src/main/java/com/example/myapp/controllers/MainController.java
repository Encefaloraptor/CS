package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    // Lista que almacenará los votos por cada película
    private List<Integer> votosFoto = new ArrayList<>();

    // Constructor: inicializa la lista con 0 votos por cada imagen
    public MainController() {
        // Suponiendo 3 fotos
        votosFoto.add(0);
        votosFoto.add(0);
        votosFoto.add(0);
    }

    // Página principal
    @GetMapping("/")
    public String mostrarPagina(Model model) {
        model.addAttribute("votosFoto", votosFoto);
        return "index"; // nombre del archivo HTML sin la extensión
    }

    // Acción de voto
    @GetMapping("/voto")
    public String votar(
            @RequestParam(name = "foto", required = false) Integer foto,
            Model model) {

    String  txtErr = null;
        // Validar voto
        if (foto == null || foto < 0 ) {
        txtErr = "Voto invalido";
        } else {
            // Incrementar el contador correspondiente
            votosFoto.set(foto, votosFoto.get(foto) + 1);
        }

        model.addAttribute("votosFoto", votosFoto);
        model.addAttribute("txtErr", txtErr);

        // Mostrar la misma página después de votar
        return "index";
    }
}

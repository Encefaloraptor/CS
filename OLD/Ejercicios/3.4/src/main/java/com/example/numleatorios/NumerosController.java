package com.example.numleatorios;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@SessionScope   --> en el tema siguiente veremos que es esto
@Controller
public class NumerosController {
    Random random = new Random();
    public Set<Integer> lista = new LinkedHashSet<>();

    @GetMapping({ "/", "/list", "" })
    public String showList(Model model) {
            model.addAttribute("cantidadTotal", lista.size());
            model.addAttribute("listaNumeros", lista);
        
                if (lista.isEmpty()) {
                    model.addAttribute("ocultar", false);
                }else{
                    model.addAttribute("ocultar", true);
                }
        return "listView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        boolean añadido;
        do {
            int numeroRamdon = random.nextInt(100) + 1;
            añadido = lista.add(numeroRamdon);
            
        } while (!añadido);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id) {
        lista.remove(id);
        return "redirect:/list";
    }
}

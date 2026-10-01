package com.example.ejercicios_tema_2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ejercicios_tema_2.service.MatematicasService;

@Controller
@RequestMapping("/random-numbers")
public class RandomNumberController {

    @Autowired
    MatematicasService rdmServ;

    @GetMapping("/home")
    public String getNumbersPage(Model model) {
        model.addAttribute("totalNumbers", rdmServ.getNumbers().size());
        model.addAttribute("numbers", rdmServ.getNumbers());
        return "numbers";
    }

    @GetMapping("/new")
    public String addRandomNumber() {
        rdmServ.addRandomNumber();
        return "redirect:/random-numbers/home";
    }

    @GetMapping("/delete/{number}")
    public String deleteNumber(@PathVariable Integer number) {
        rdmServ.removeNumber(number);
        return "redirect:/random-numbers/home";
    }
}

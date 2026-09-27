package com.example.myapp;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showMenu(Model model) {
        model.addAttribute("fechaActual", LocalDate.now().getYear());
        model.addAttribute("myId", 3);
        model.addAttribute("mySize", "big");
        return "homeView";
    }

    @GetMapping("/quienes-somos/")
    public String showAboutUs(Model model) {
        return "quienesSomosView";
    }

    @GetMapping("/product")
    public String showProductQuery (@RequestParam Integer id, @RequestParam String size, Model model){
        model.addAttribute("identif",id);
        model.addAttribute("talla",size);
        return "productView";
    }

    @GetMapping("/product/{id}/{size}")
    public String showProductPath (@PathVariable Integer id, @PathVariable String size, Model model){
        model.addAttribute("identif",id);
        model.addAttribute("talla",size);
        return "productView";
    }
}

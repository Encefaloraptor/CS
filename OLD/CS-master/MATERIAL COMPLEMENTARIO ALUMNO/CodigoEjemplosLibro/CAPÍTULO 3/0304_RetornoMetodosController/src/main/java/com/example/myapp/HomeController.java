package com.example.myapp;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping({ "/", "/menuprincipal" })
    public String showMenu(Model model) {
        model.addAttribute("fechaActual", LocalDate.now().getYear());
        return "menuView";
    }

    @GetMapping("/par/{num}")
    public String showPar(@PathVariable Integer num, Model model) {
        if (num < 1)
            return "redirect:/menuprincipal";
        model.addAttribute("par", num % 2);
        return "parView";
    }

    @GetMapping("/menuConModelAndView")
    public ModelAndView showMenu2() {
        ModelAndView modelAndview = new ModelAndView();
        modelAndview.addObject("fechaActual", LocalDate.now().getYear());
        modelAndview.setViewName("menuView");
        return modelAndview;
    }

}

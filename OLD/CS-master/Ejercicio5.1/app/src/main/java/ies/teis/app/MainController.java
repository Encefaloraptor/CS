package ies.teis.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String showForm( Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "formView";
    }

    @PostMapping("/resultado")
    public String showSubmit(FormInfo formInfo, Model model) {
        int resultado = formInfo.getNum1() * formInfo.getNum2();
        model.addAttribute("resultado", resultado);
        return "indexView";
    }
        
}

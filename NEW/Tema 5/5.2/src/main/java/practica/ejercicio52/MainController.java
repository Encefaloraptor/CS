package practica.ejercicio52;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class MainController {
    @GetMapping({ "/", "/myForm" })
    public String showForm(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "index";
    }

    @PostMapping("/myForm/submit")
    public String showMyformSubmit(@Valid FormInfo formInfo, BindingResult bindingResult,
            @RequestParam("operation") String operation, Model model) {
        if (bindingResult.hasErrors())
            return "index";

        model.addAttribute("operation", operation);
        switch (operation) {
            case "days" -> model.addAttribute("daysResult", formInfo.diasEntreFechas());
            case "leapYears" -> model.addAttribute("leapYearsResult", formInfo.añosBisiestos());
            case "sundays" -> model.addAttribute("sundaysResult", formInfo.domingoUnoEnero());
            default -> model.addAttribute("operationError", "Selecciona una operación válida.");
        }
        return "index";
    }
}
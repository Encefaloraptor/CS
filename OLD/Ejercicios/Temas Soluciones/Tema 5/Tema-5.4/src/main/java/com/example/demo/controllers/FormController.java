package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.services.EmailService;
import com.example.demo.services.FileManager;

import jakarta.validation.Valid;





@Controller
public class FormController {
    @Autowired
    FileManager manejador;

    @Autowired
    EmailService enviador;
    @GetMapping("/formulario")
    public String getMethodName(Model model) {
        model.addAttribute("formulario", new FormInfo());
        return "FormView";
    }

    @PostMapping("/formulario/submit")
    public String postMethodName(@Valid @ModelAttribute("formulario") FormInfo formulario, BindingResult bindingResult, @RequestParam MultipartFile file, RedirectAttributes model) {
        String resultado;
        boolean exito;
        if(bindingResult.hasErrors()){
            return "FormView";
        }
        
        try {
            String nuevoFicheroNombre = manejador.guardarFichero(file, formulario.getDni());
            formulario.setNombreFicheroString(nuevoFicheroNombre);
            String destinatario = formulario.getEmail();
            String texto = formulario.toString();
            String asunto = "Formulario de " + formulario.getNombre();
            String archivoAdjunto = "uploadDir/" + formulario.getNombreFicheroString();
            enviador.enviarEmail(destinatario, asunto, texto, archivoAdjunto);
            model.addFlashAttribute("resultado", resultado = "Correo enviado con éxito");
            model.addFlashAttribute("exito", exito = true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addFlashAttribute("resultado", resultado = "El correo no se ha podido enviar");
            model.addFlashAttribute("exito", exito = false);
        }
        return "redirect:/formulario";
    }
    
    
}

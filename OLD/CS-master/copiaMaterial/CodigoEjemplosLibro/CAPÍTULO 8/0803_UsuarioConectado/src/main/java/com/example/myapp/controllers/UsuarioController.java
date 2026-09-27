package com.example.myapp.controllers;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.domain.Usuario;
import com.example.myapp.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.obtenerTodos());
        return "user/userListView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("usuarioForm", new Usuario());
        return "user/userNewView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("usuarioForm") Usuario nuevoUsuario,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors())
                    usuarioService.añadir(nuevoUsuario);
        return "redirect:/usuarios/";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Usuario usuario = usuarioService.obtenerPorId(id);
        if (usuario != null) {
            model.addAttribute("usuarioForm", usuario);
            return "user/userEditView";
        } else {
            return "redirect:/usuarios/";
        }
    }

    @PostMapping("/editar/submit")
    public String showEditSubmit(@Valid @ModelAttribute("usuarioForm") Usuario usuario,
            BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) 
            usuarioService.editar(usuario);
        return "redirect:/usuarios/";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id) {
        usuarioService.borrar(id);
        return "redirect:/usuarios/";
    }

}

package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientResponseException;

@Controller
public class RestClientController {

    @Autowired
    public RestClientService restClientService;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("todo", new Todo());
        return "indexView";
    }

    @GetMapping("/lista")
    public String getAll(Model model) {
        try {
            model.addAttribute("todos", restClientService.obtenerTodos());
        } catch (RestClientResponseException e) {
            model.addAttribute("error", e.getMessage());
            return "errorView";
        }
        return "showAllView";
    }

    @GetMapping("/get/{id}")
    public String getOne(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("todo", restClientService.obtenerPorId(id));
        } catch (RestClientResponseException e) {
            model.addAttribute("error", e.getMessage());
            return "errorView";
        }
        return "showOneView";
    }

    @PostMapping("/nuevo")
    public String postOne(Todo todo, Model model) {
        try {
            restClientService.añadir(todo);
            model.addAttribute("todo", todo);
        } catch (RestClientResponseException e) {
            model.addAttribute("error", e.getMessage());
            return "errorView";
        }
        return "showPostView";
    }
}
package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class ProductosController {
    @GetMapping("/productos")
    public String getList() {
        // proceso
        return "productoListView";
    }

    @GetMapping("/eliminar/{id}")
    public String removeItem(@PathVariable Long id) {
        // proceso
        return "productoDeleteView";
    }

    @GetMapping("/nuevo")
    public String newItem() {
        // procesoºº
        return "productoNewView";
    }
  

}
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Producto;
import com.example.repository.ProductoRepository;

@Controller
public class ProductoController {

  @Autowired
  ProductoRepository productoRepository;

  @GetMapping({ "/", "/list" })
  public String showList(Model model) {
    model.addAttribute("productos", productoRepository.obtenerTodos());
    return "listView";
  }

  @GetMapping("/nuevo")
  public String showNew(Model model) {
    model.addAttribute("productoForm", new Producto());
    return "newFormView";
  }

  @PostMapping("/nuevo/submit")
  public String showNewSubmit(Producto productoForm) {
    productoRepository.añadir(productoForm);
    return "redirect:/";
  }

  @GetMapping("/editar/{id}")
  public String showEditForm(@PathVariable long id, Model model) {
    Producto producto = productoRepository.obtenerPorClave(id);
    model.addAttribute("productoForm", producto);
    return "editFormView";
  }

  @PostMapping("/editar/{id}/submit")
  public String showEditSubmit(@PathVariable Long id, Producto productoForm) {
    productoRepository.actualizar(productoForm);
    return "redirect:/";
  }

  @GetMapping("/borrar/{id}")
  public String showDelete(@PathVariable long id) {
    productoRepository.borrarPorClave(id);
    return "redirect:/";
  }
}

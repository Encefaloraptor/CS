package com.example.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.domain.Empleado;
import com.example.myapp.services.EmpleadoService;

@RestController
public class EmpleadoController {

    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public ResponseEntity<?> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if (listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(listaEmpleados); // cod 200

    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado != null) {
            Link link = WebMvcLinkBuilder.linkTo(EmpleadoController.class)
                    .slash("empleado").slash(empleado.getId()).withSelfRel();
            empleado.add(link);
            Link link2 = WebMvcLinkBuilder.linkTo(EmpleadoController.class)
                    .slash("empleado").withRel("all");
            empleado.add(link2);
            return ResponseEntity.ok(empleado); // cod 200
        } else
            return ResponseEntity.notFound().build(); // cod 404
    }
}
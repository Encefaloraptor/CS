package com.example.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.domain.Empleado;
import com.example.myapp.services.EmpleadoService;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {

    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public List<Empleado> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        return listaEmpleados;
    }

    @GetMapping("/empleado/{id}")
    public Empleado getOneElement(@PathVariable Long id) {
        return empleadoService.obtenerPorId(id);
    }

    @PostMapping("/empleado")
    public ResponseEntity<?> newElement(@Valid @RequestBody Empleado nuevoEmpleado) {
        Empleado empleado = empleadoService.añadir(nuevoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado); // cod 201
    }

    @PutMapping("/empleado/{id}")
    public Empleado editElement(@Valid @RequestBody Empleado editEmpleado,
            @PathVariable Long id) {
        empleadoService.obtenerPorId(id); // ejecutamos esto para ver si se produce excepcion
        return empleadoService.editar(editEmpleado);
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        empleadoService.borrar(id);
        return ResponseEntity.noContent().build(); // cod 204
    }
}

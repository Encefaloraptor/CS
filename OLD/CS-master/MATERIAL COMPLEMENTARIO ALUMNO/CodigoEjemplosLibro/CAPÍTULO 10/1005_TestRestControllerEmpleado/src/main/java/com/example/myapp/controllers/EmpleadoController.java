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
    public ResponseEntity<?> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if (listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(listaEmpleados); // cod 200

    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        try {
            Empleado empleado = empleadoService.obtenerPorId(id);
            return ResponseEntity.ok(empleado); // cod 200
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // cod 404
        }
    }

    @PostMapping("/empleado") // puede ser la misma URI que las anteriores ya que es otro verbo!
    public ResponseEntity<?> newElement(@Valid @RequestBody Empleado nuevoEmpleado) {
        // @Valid si no se cumple la validación devuelve BAD_REQUEST //cod 400
        try {
            Empleado empleado = empleadoService.añadir(nuevoEmpleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(empleado); // cod 201
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // cod 400
        }
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@Valid @RequestBody Empleado editEmpleado, @PathVariable Long id) {
        // @Valid si no se cumple la validación devuelve BAD_REQUEST //cod 400
        try {
            Empleado empleado = empleadoService.obtenerPorId(id);
            empleado = empleadoService.editar(editEmpleado);
            return ResponseEntity.ok(empleado); // cod 200
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // cod 404
        }
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        try {
            Empleado empleado = empleadoService.obtenerPorId(id);
            empleadoService.borrar(id);
            return ResponseEntity.noContent().build(); // cod 204
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // cod 404
        }
    }
}
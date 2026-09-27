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

import com.example.myapp.domain.Departamento;
import com.example.myapp.services.DepartamentoService;

@RestController
public class DepartamentoController {

    @Autowired
    public DepartamentoService departamentoService;

    @GetMapping("/depto")
    public ResponseEntity<?> getList() {
        List<Departamento> listaDepartamento = departamentoService.obtenerTodos();
        if (listaDepartamento.isEmpty())
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(listaDepartamento); // cod 200
    }

    @GetMapping("/depto/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento == null)
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(departamento); // cod 200
    }

    @PostMapping("/depto")
    public ResponseEntity<?> newElement(@RequestBody Departamento nuevoDepartamento) {
        Departamento departamento = departamentoService.añadir(nuevoDepartamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamento); // cod 201
    }

    @PutMapping("/depto/{id}")
    public ResponseEntity<?> editElement(@RequestBody Departamento editDepartamento,
            @PathVariable Long id) {

        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
            departamento = departamentoService.editar(editDepartamento);
            return ResponseEntity.ok(departamento); // cod 200
        }
    }

    @DeleteMapping("/depto/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        departamentoService.borrar(id);
        return ResponseEntity.noContent().build(); // cod 204
    }

}

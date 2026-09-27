package com.example.myapp.controllers;

import java.util.ArrayList;
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
import com.example.myapp.dto.EmpleadoDto;
import com.example.myapp.dto.EmpleadoNuevoDto;
import com.example.myapp.services.DepartamentoService;
import com.example.myapp.services.EmpleadoDtoConverter;
import com.example.myapp.services.EmpleadoService;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;
    @Autowired
    public DepartamentoService departamentoService;
    @Autowired
    public EmpleadoDtoConverter empleadoDtoConverter;

    @GetMapping("/empleado")
    public ResponseEntity<?> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if (listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build(); // cod 404
        else {
            List<EmpleadoDto> listaEmpleadoDto = new ArrayList<>();
            for (Empleado empleado : listaEmpleados)
                listaEmpleadoDto.add(empleadoDtoConverter.convertEmpleadoToDto(empleado));
            return ResponseEntity.ok(listaEmpleadoDto); // cod 200
        }
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(empleado); // cod 200
    }

    @PostMapping("/empleado")
    public ResponseEntity<?> newElement(@RequestBody EmpleadoNuevoDto empleadoNuevoDto) {
        Empleado empleado = empleadoDtoConverter.convertDtoToEmpleado(empleadoNuevoDto);
        Empleado empleadoSaved = empleadoService.añadir(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSaved); // cod 201
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@RequestBody EmpleadoNuevoDto editEmpleado,
            @PathVariable Long id) {

        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
            empleado = empleadoDtoConverter.convertDtoToEmpleado(editEmpleado, id);
            Empleado empleadoSaved = empleadoService.editar(empleado);
            return ResponseEntity.ok(empleadoSaved); // cod 200
        }
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        empleadoService.borrar(id);
        return ResponseEntity.noContent().build(); // cod 204
    }

}

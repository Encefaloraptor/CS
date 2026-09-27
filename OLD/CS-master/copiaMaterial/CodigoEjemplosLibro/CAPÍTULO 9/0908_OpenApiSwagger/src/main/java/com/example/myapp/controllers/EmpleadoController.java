package com.example.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.domain.Empleado;
import com.example.myapp.services.EmpleadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clase Empleado", description = "Empleados de la organización")
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping("/")
    public ResponseEntity<?> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if (listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(listaEmpleados);

    }

    @Operation(summary = "resumen de la operación (del mapping)", description = "Descripción de la operación (del mapping).", tags = {
            "etiquetas calificadoras", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Empleado.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneElement(
            @Parameter(name = "id", description = "identific. único del empleado", example = "1", required = true) @PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado != null)
            return ResponseEntity.ok(empleado);
        else
            return ResponseEntity.notFound().build();
    }

}
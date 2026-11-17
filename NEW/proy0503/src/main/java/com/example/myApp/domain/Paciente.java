package com.example.myApp.domain;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;

import com.example.myApp.config.Tarifas;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "dni")

public abstract class Paciente {

    @NotEmpty
    protected String dni;
    @NotEmpty
    protected String nombre;
    protected LocalDate fechaNacimiento;

    public abstract double facturar(Tarifas tarifas);
}
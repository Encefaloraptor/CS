package com.example.myApp.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Contiene todos los atributos necesarios para crear un nuevo paciente
// independientemente de su tipo
public class NewPacienteDTO {
    @Min(1)
    @Max(3)
    private int tipoPaciente;

    @Size(min = 5, max = 13)
    private String dni;

    @NotEmpty
    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private LocalDate fechaNacimiento;

    private String motivoConsulta;

    private String medicamentos;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVisitaAnterior;
}

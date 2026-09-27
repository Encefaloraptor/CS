package com.example.myapp.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Empleado {

    @Min(value = 0)
    private Long id;

    @NotEmpty
    private String nombre;

    private Double salarioBase;

    private Double salarioFinal;
}

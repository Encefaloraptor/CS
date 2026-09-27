package com.example.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoNuevoDto {
    private String nombre;
    private String email;
    private Double salario;
    private Long departamentoId;
}

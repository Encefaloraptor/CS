package com.example.myapp.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientForm {
    @Min(0) @Max(20)
    private Integer embarazos;
    @Min(1) @Max(200)
    private Integer glucosa;
    @Min(0) @Max(140)
    private Integer presionSangre;
    @Min(0) @Max(100)
    private Integer grosorPiel;
    @Min(0) @Max(900)
    private Integer insulina;
    @Min(0) @Max(80)
    private Integer indiceMasaCorporal;
    @Min(0) @Max(2)
    private Float herencia;
    @Min(18) @Max(100)
    private Integer edad;
   
}

package com.example.myApp.domain;

import com.example.myApp.config.Tarifas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

public class PacienteConsulta extends Paciente {

    private String motivoConsulta;

    public double facturar(Tarifas tarifas) {
        return tarifas.getTarifaConsulta();
    }
}
package com.example.myApp.domain;

import java.util.List;

import com.example.myApp.config.Tarifas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

public class PacienteRecetas extends Paciente {

    private List<String> medicamentos;

    @Override
    public double facturar(Tarifas tarifas) {
        return this.medicamentos.size() * tarifas.getTarifaReceta();
    }
}
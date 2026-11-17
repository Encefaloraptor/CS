package com.example.myApp.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.example.myApp.config.Tarifas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

public class PacienteRevision extends Paciente {

    private LocalDate fechaVisitaAnterior;

    public double facturar(Tarifas tarifas) {
        long edad = ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
        if (edad > 65)
            return tarifas.getTarifaRevisionJubilado();
        return tarifas.getTarifaRevisionAdulto();
    }
}

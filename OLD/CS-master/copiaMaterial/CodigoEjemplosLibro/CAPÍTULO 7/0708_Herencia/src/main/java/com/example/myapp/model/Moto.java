package com.example.myapp.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
// Si en superclase :@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
// añadimos:
// @DiscriminatorValue(value = "Moto")
public class Moto extends Vehiculo {
    private int potencia;

    public Moto(Long id, String modelo, Double precio, int potencia) {
        super(id, modelo, precio);
        this.potencia = potencia;
    }

}

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
// @DiscriminatorValue(value = "Coche")
public class Coche extends Vehiculo {
    private int peso;

    public Coche(Long id, String modelo, Double precio, int peso) {
        super(id, modelo, precio);
        this.peso = peso;
    }

}

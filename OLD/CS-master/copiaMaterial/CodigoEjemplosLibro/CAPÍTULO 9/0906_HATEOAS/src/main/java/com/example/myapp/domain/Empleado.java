package com.example.myapp.domain;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "id")

@Entity
public class Empleado extends RepresentationModel<Empleado> {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String nombre;

    @Email
    private String email;

    private Double salario;
}

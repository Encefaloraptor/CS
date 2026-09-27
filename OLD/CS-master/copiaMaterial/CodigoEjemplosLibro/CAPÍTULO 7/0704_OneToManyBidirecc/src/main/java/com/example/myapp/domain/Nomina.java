package com.example.myapp.domain;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Nomina {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate fechaNomina;

        Double importeBruto;

        Double porcentImpuestos;

        Double importeNeto;

        @ManyToOne
        @OnDelete(action = OnDeleteAction.CASCADE)
        private Empleado empleado;
}

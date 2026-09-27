package com.example.myapp.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ColaboracionId.class)
public class Colaboracion {

    @Id
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Empleado empleado;

    @Id
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Proyecto proyecto;

    private String puesto;
}

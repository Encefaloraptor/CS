package com.example.myapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.domain.Colaboracion;
import com.example.myapp.domain.ColaboracionId;

public interface ColaboracionRepository extends JpaRepository<Colaboracion, ColaboracionId> {

    List<Colaboracion> findByEmpleadoId(Long empleadoId);

    List<Colaboracion> findByProyectoId(Long proyectoId);

    // No lo vamos a emplear en este ejemplo:
    Colaboracion findByEmpleadoIdAndProyectoId(Long emp, Long proy);
}

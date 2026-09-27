package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Colaboracion;

public interface ColaboracionService {
    public Colaboracion obtenerPorId(Long id);

    Colaboracion añadir(Colaboracion Colaboracion);

    void borrar(Colaboracion Colaboracion);

    List<Colaboracion> obtenerPorEmpleadoId(Long empleadoId);

    List<Colaboracion> obtenerPorProyectoId(Long proyectoId);

    Colaboracion obtenerColaboracion(Long e, Long p);

}

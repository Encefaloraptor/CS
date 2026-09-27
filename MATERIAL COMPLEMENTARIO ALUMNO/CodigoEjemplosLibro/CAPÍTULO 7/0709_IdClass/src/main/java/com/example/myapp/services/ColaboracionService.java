package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Colaboracion;
import com.example.myapp.domain.ColaboracionId;

public interface ColaboracionService {
    public Colaboracion obtenerPorId(ColaboracionId id);

    Colaboracion añadir(Colaboracion Colaboracion);

    void borrar(Colaboracion Colaboracion);

    List<Colaboracion> obtenerPorEmpleadoId(Long empleadoId);

    List<Colaboracion> obtenerPorProyectoId(Long proyectoId);

    Colaboracion obtenerColaboracion(Long e, Long p);

}

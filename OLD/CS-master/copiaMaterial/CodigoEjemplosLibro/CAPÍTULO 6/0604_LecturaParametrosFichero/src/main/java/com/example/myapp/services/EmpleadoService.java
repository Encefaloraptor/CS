package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Empleado;

public interface EmpleadoService {

    List<Empleado> obtenerTodos();

    Empleado añadir(Empleado empleado);
}

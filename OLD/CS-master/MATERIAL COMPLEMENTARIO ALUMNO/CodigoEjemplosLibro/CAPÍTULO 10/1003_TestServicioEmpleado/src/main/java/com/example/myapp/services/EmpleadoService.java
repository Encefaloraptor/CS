package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Empleado;

public interface EmpleadoService {
    Empleado añadir(Empleado empleado) throws RuntimeException;

    List<Empleado> obtenerTodos();

    List<Empleado> obtenerActivos();

    Empleado obtenerPorId(Long id);

    Empleado editar(Empleado empleado) throws RuntimeException;

    void borrar(Long id) throws RuntimeException;
}
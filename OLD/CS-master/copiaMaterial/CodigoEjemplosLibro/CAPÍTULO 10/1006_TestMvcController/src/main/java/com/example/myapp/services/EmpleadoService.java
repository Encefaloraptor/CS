package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Empleado;

public interface EmpleadoService {

    List<Empleado> obtenerTodos();

    Empleado obtenerPorId(long id) throws RuntimeException;

    Empleado añadir(Empleado empleado);

    Empleado editar(Empleado empleado) throws RuntimeException;

    void borrar(Long id) throws RuntimeException;

}

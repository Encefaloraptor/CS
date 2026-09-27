package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;

public interface EmpleadoService {

    List<Empleado> obtenerTodos();

    List<Empleado> buscarPorNombre(String textoNombre);

    List<Empleado> buscarPorGenero(Genero genero);

    Empleado añadir(Empleado empleado);
}

package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Nomina;

public interface NominaService {

    Nomina añadir(Nomina nomina);

    List<Nomina> obtenerTodos();

    Nomina obtenerPorId(long id);

    Nomina editar(Nomina nomina);

    void borrar(Long id);

    // No necesario al ser relacion bidireccional
    List<Nomina> obtenerPorEmpleado(Empleado empleado);

    // No necesario al ser relacion bidireccional
    List<Nomina> obtenerPorEmpleadoId(Long empleadoId);

}

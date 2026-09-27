package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Empleado;
import com.example.myapp.dto.EmpleadoDTO;

public interface EmpleadoService {
    Empleado añadir(Empleado e);

    List<Empleado> obtenerTodos();

    Empleado obtenerPorId(long id);

    Empleado editar(Empleado e);

    void borrar(Long id);

    List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados);
}

package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Departamento;

public interface DepartamentoService {
    Departamento añadir(Departamento departamento);

    List<Departamento> obtenerTodos();

    Departamento obtenerPorId(long id);

    Departamento editar(Departamento departamento);

    void borrar(Long id);

    Departamento obtenerPorNombre(String nombre);

}

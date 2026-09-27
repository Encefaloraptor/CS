package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Departamento;

public interface DepartamentoService {
    Departamento añadir(Departamento d);

    List<Departamento> obtenerTodos();

    Departamento obtenerPorId(long id);

    Departamento editar(Departamento d);

    void borrar(Departamento d);

}

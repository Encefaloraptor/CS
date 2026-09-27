package com.example.myapp.services;

import java.util.List;

import com.example.myapp.domain.Proyecto;

public interface ProyectoService {
    Proyecto añadir(Proyecto proyecto);

    List<Proyecto> obtenerTodos();

    Proyecto obtenerPorId(long id);

    Proyecto editar(Proyecto proyecto);

    void borrar(Proyecto proyecto);

}

package com.example.repository;

import java.util.List;

import com.example.model.Producto;

public interface ProductoRepository {

  int añadir(Producto producto);

  int actualizar(Producto producto);

  Producto obtenerPorClave(Long id);

  int borrarPorClave(Long id);

  List<Producto> obtenerTodos();

  List<Producto> obtenerPorPrecio(Double precio);

}

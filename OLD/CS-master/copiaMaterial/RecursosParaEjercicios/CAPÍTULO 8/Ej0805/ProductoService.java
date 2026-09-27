package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Producto;
import com.example.myapp.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepositorio;

    private final Float TASA_USD = 1.1f;
    private final Float TASA_GBP = 0.8f;

    public List<Producto> obtenerTodos(String moneda) {
        List<Producto> listaProductos = productoRepositorio.findAll();
        for (Producto producto : listaProductos) {
            switch (moneda) {
                case "USD" -> producto.setPrecio(producto.getPrecio() * TASA_USD);
                case "GBP" -> producto.setPrecio(producto.getPrecio() * TASA_GBP);
            }
        }
        return listaProductos;
    }
}

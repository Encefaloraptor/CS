package com.example.myapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private List<Empleado> repositorio = new ArrayList<>();

    public List<Empleado> obtenerTodos() {
        return repositorio;
    }

    public List<Empleado> buscarPorNombre(String textoNombre) {
        textoNombre = textoNombre.toLowerCase();
        List<Empleado> encontrados = new ArrayList<>();
        for (Empleado empleado : repositorio)
            if (empleado.getNombre().toLowerCase().contains(textoNombre))
                encontrados.add(empleado);
        return encontrados;
    }

    public List<Empleado> buscarPorGenero(Genero genero) {
        List<Empleado> encontrados = new ArrayList<>();
        for (Empleado empleado : repositorio)
            if (empleado.getGenero() == genero)
                encontrados.add(empleado);
        return encontrados;
    }

    public Empleado añadir(Empleado empleado) {
        if (repositorio.contains(empleado))
            return null;
        repositorio.add(empleado);
        return empleado;
    }
}

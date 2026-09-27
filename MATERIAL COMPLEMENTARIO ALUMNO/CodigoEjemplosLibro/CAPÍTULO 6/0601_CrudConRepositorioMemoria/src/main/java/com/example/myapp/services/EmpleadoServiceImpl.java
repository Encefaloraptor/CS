package com.example.myapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private List<Empleado> repositorio = new ArrayList<>();

    public List<Empleado> obtenerTodos() {
        return repositorio;
    }

    public Empleado obtenerPorId(long id) {
        for (Empleado empleado : repositorio)
            if (empleado.getId() == id)
                return empleado;
        return null; // podría lanzar excepción si no encontrado
    }

    public Empleado añadir(Empleado empleado) {
        if (repositorio.contains(empleado))
            return null;
        // ver equals Empleado (mismo id)
        repositorio.add(empleado);
        return empleado; // podría no devolver nada, o boolean, etc

    }

    public Empleado editar(Empleado empleado) {
        int pos = repositorio.indexOf(empleado);
        // if (pos == -1) throw new RuntimeException ("Empleado no encontrado");
        if (pos == -1)
            return null;
        repositorio.set(pos, empleado);
        return empleado;
    }

    public void borrar(Long id) {
        Empleado empleado = this.obtenerPorId(id);
        if (empleado != null)
            repositorio.remove(empleado);
    }
}

package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.exceptions.EmpleadoNotFoundException;
import com.example.myapp.exceptions.EmpleadosEmptyException;
import com.example.myapp.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public List<Empleado> obtenerTodos() {
        List<Empleado> lista = repositorio.findAll();
        if (lista.isEmpty())
            throw new EmpleadosEmptyException();
        return lista;
    }

    public Empleado obtenerPorId(long id) throws EmpleadoNotFoundException {
        Empleado empleado = repositorio.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
        return empleado;
    }

    public Empleado editar(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public void borrar(Long id) throws EmpleadoNotFoundException {
        Empleado empleado = repositorio.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
        repositorio.delete(empleado);
    }
}

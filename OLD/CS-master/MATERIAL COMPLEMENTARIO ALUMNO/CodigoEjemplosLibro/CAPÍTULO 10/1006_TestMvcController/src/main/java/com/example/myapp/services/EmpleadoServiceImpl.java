package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;

    public List<Empleado> obtenerTodos() {
        return repositorio.findAll();
    }

    public Empleado obtenerPorId(long id) throws RuntimeException {
        return repositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Empleado no encontrado"));
    }

    public Empleado añadir(Empleado empleado) {
        return repositorio.save(empleado);
    }

    public Empleado editar(Empleado empleado) throws RuntimeException {
        return repositorio.save(empleado);
    }

    public void borrar(Long id) throws RuntimeException {
        obtenerPorId(id); // lanza excepción si no existe
        repositorio.deleteById(id);
    }
}

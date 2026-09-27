package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;

    private final Double MIN_SALAR = 18000D;

    public List<Empleado> obtenerTodos() {
        return repositorio.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public Empleado obtenerPorId(long id) throws RuntimeException {
        return repositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Empleado no encontrado"));

    }

    public Empleado añadir(Empleado empleado) {
        if (empleado.getSalario() < MIN_SALAR)
            throw new RuntimeException("Salario muy bajo");
        return repositorio.save(empleado);
    }

    public Empleado editar(Empleado empleado) throws RuntimeException {
        obtenerPorId(empleado.getId()); // lanza excepción si no existe
        if (empleado.getSalario() < MIN_SALAR)
            throw new RuntimeException("Salario muy bajo");
        return repositorio.save(empleado);
    }

    public void borrar(Long id) throws RuntimeException {
        obtenerPorId(id); // lanza excepción si no existe
        repositorio.deleteById(id);
    }

}

package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;

import com.example.myapp.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    private final Double MIN_SALAR = 18000D;

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado añadir(Empleado empleado) {
        if (empleado.getSalario() < MIN_SALAR)
            return null;
        return empleadoRepository.save(empleado);
    }

    public Empleado editar(Empleado empleado) {
        if (empleado.getSalario() < MIN_SALAR)
            return null;
        return empleadoRepository.save(empleado);
    }

    public void borrar(Long id) throws RuntimeException {
        empleadoRepository.deleteById(id);
    }
}

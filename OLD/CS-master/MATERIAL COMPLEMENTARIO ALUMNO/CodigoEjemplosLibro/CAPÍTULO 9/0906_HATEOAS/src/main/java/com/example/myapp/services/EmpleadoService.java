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

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado añadir(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}

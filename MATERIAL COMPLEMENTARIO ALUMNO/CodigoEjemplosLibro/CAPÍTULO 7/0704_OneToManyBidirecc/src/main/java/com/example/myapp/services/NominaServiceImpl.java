package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Nomina;
import com.example.myapp.repositories.EmpleadoRepository;
import com.example.myapp.repositories.NominaRepository;

@Service
public class NominaServiceImpl implements NominaService {

    @Autowired
    NominaRepository nominaRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    public Nomina añadir(Nomina nomina) {
        return nominaRepository.save(nomina);
    }

    public List<Nomina> obtenerTodos() {
        return nominaRepository.findAll();
    }

    public Nomina obtenerPorId(long id) {
        return nominaRepository.findById(id).orElse(null);
    }

    public Nomina editar(Nomina nomina) {
        return nominaRepository.save(nomina);
    }

    public void borrar(Long id) {
        nominaRepository.deleteById(id);
    }

    // No necesario al ser relacion bidireccional
    public List<Nomina> obtenerPorEmpleado(Empleado empleado) {
        return nominaRepository.findByEmpleado(empleado);
    }

    // No necesario al ser relacion bidireccional
    public List<Nomina> obtenerPorEmpleadoId(Long empleadoId) {
        return nominaRepository.findByEmpleadoId(empleadoId);
    }
}

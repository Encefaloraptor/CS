package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Colaboracion;
import com.example.myapp.domain.ColaboracionId;
import com.example.myapp.repositories.ColaboracionRepository;

@Service
public class ColaboracionServiceImpl implements ColaboracionService {

    @Autowired
    ColaboracionRepository colaboracionRepository;

    public Colaboracion obtenerPorId(ColaboracionId id) {
        return colaboracionRepository.findById(id).orElse(null);
    }

    public Colaboracion añadir(Colaboracion e) {
        return colaboracionRepository.save(e);
    }

    public void borrar(Colaboracion d) {
        colaboracionRepository.delete(d);
    }

    public List<Colaboracion> obtenerPorEmpleadoId(Long empleadoId) {
        return colaboracionRepository.findByEmpleadoId(empleadoId);
    }

    public List<Colaboracion> obtenerPorProyectoId(Long proyectoId) {
        return colaboracionRepository.findByProyectoId(proyectoId);
    }

    public Colaboracion obtenerColaboracion(Long e, Long p) {
        return colaboracionRepository.findByEmpleadoIdAndProyectoId(e, p);
    }

}

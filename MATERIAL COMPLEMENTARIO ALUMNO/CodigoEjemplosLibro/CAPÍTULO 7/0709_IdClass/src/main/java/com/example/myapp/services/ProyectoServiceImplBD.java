package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Proyecto;
import com.example.myapp.repositories.ProyectoRepository;

@Service
@Primary
public class ProyectoServiceImplBD implements ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    public Proyecto añadir(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    public Proyecto obtenerPorId(long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    public Proyecto editar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public void borrar(Proyecto d) {
        proyectoRepository.delete(d);
    }

}

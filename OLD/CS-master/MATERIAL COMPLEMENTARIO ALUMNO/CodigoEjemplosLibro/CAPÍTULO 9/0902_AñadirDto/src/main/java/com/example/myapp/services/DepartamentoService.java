package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Departamento;
import com.example.myapp.repositories.DepartamentoRepository;

@Service
@Primary
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public Departamento añadir(Departamento e) {
        return departamentoRepository.save(e);
    }

    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento obtenerPorId(long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public Departamento editar(Departamento d) {
        return departamentoRepository.save(d);
    }

    public void borrar(Long id) {
        departamentoRepository.deleteById(id);
    }
}

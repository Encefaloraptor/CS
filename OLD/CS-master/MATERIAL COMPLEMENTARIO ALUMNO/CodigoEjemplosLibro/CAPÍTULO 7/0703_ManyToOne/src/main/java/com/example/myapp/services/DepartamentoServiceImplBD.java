package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Departamento;
import com.example.myapp.repositories.DepartamentoRepository;
import com.example.myapp.repositories.EmpleadoRepository;

@Service
public class DepartamentoServiceImplBD implements DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    public Departamento añadir(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento obtenerPorId(long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public Departamento editar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void borrar(Long id) {
        departamentoRepository.deleteById(id);
    }

    public Departamento obtenerPorNombre(String nombre) {
        return departamentoRepository.findByNombre(nombre);
    }
}

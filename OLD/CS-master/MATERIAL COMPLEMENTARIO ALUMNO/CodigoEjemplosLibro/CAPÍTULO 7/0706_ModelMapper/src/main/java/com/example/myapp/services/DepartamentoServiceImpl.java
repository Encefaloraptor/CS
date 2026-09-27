package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Departamento;
import com.example.myapp.repositories.DepartamentoRepository;
import com.example.myapp.repositories.EmpleadoRepository;

@Service
@Primary
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    public Departamento añadir(Departamento d) {
        return departamentoRepository.save(d);
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

    public void borrar(Departamento d) {
        // Long cantEmpleadosDepto =
        // empleadoRepository.cantidadEmpleadosDepto(d.getId());
        // if (cantEmpleadosDepto == 0)
        departamentoRepository.delete(d);
    }

}

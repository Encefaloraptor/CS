package com.example.myapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.config.Parametros;
import com.example.myapp.domain.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private List<Empleado> repositorio = new ArrayList<>();

    @Autowired
    private Parametros parametros;

    public List<Empleado> obtenerTodos() {
        return repositorio;
    }

    public Empleado añadir(Empleado empleado) {
        if (repositorio.contains(empleado))
            return null;
        Double salarioFinal = empleado.getSalarioBase() * (1 - parametros.getPorcentajeImpuesto())
                + parametros.getBonus();
        empleado.setSalarioFinal(salarioFinal);
        repositorio.add(empleado);
        return empleado;
    }
}

package com.example.myapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepository repositorio;

    private static Double LIMITE_MIN_SALARIO = 18000D;
    private static Double LIMITE_MAX_SALARIO = 100000D;

    public List<Empleado> obtenerTodos() {
        return repositorio.findAll();
    }

    public List<Empleado> obtenerActivos() {
        List<Empleado> empleados = repositorio.findAll();
        List<Empleado> activos = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.isEnActivo())
                activos.add(empleado);
        }
        return activos;
    }

    public Empleado obtenerPorId(Long id) throws RuntimeException {
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    public Empleado añadir(Empleado empleado) throws RuntimeException {
        if (empleado.getSalario() >= LIMITE_MIN_SALARIO && empleado.getSalario() < LIMITE_MAX_SALARIO)
            return repositorio.save(empleado);
        else
            throw new RuntimeException("salario no permitido");
    }

    public Empleado editar(Empleado empleado) {
        if (empleado.getSalario() >= LIMITE_MIN_SALARIO && empleado.getSalario() < LIMITE_MAX_SALARIO)
            return repositorio.save(empleado);
        else
            throw new RuntimeException("salario no permitido");
    }

    public void borrar(Long id) throws RuntimeException {
        this.obtenerPorId(id);   //lanza excepción si no lo encuentra
        repositorio.deleteById(id);
    }
}

package com.example.myapp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;

@Service
public class EmpleadoServiceImplExcep implements EmpleadoService {
    private List<Empleado> repositorio = new ArrayList<>();
    private final Double MIN_SALAR = 18000D;

    public List<Empleado> obtenerTodos() {
        // Collection.sort ordena la lista de empleados por nombre, siendo Comparator
        // una interfaz funcional que permite comparar objetos
        Collections.sort(repositorio, Comparator.comparing(Empleado::getNombre));
        return repositorio;
    }

    public Empleado obtenerPorId(Long id) throws RuntimeException {
        for (Empleado empleado : repositorio)
            if (empleado.getId() == id)
                return empleado;
        throw new RuntimeException("Empleado no encontrado");
    }

    public Empleado añadir(Empleado empleado) throws RuntimeException {
        if (repositorio.contains(empleado))
            throw new RuntimeException("Ya existe ese id de empleado");
        if (empleado.getSalario() < MIN_SALAR)
            throw new RuntimeException("Salario muy bajo");
        repositorio.add(empleado);
        return empleado;
    }

    public Empleado editar(Empleado empleado) throws RuntimeException {
        // indexOf devuelve la posición del objeto empleado en la lista, si no lo
        // encuentra devuelve -1
        // En el controlador se captura la excepción y se muestra un mensaje de error
        int pos = repositorio.indexOf(empleado);
        if (pos == -1)
            throw new RuntimeException("Empleado no encontrado");
        if (empleado.getSalario() < MIN_SALAR)
            throw new RuntimeException("Salario muy bajo");
        repositorio.set(pos, empleado);
        return empleado;
    }

    public void borrar(Long id) throws RuntimeException {
        Empleado empleado = this.obtenerPorId(id);
        repositorio.remove(empleado);
    }

    public List<Empleado> buscarPorNombre(String textoNombre) {
        textoNombre = textoNombre.toLowerCase();
        List<Empleado> encontrados = new ArrayList<>();
        for (Empleado empleado : repositorio)
            if (empleado.getNombre().toLowerCase().contains(textoNombre))
                encontrados.add(empleado);
        return encontrados;
    }

    public List<Empleado> buscarPorGenero(Genero genero) {
        List<Empleado> encontrados = new ArrayList<>();
        for (Empleado empleado : repositorio)
            if (empleado.getGenero() == genero)
                encontrados.add(empleado);
        return encontrados;
    }
}

package com.example.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public Empleado añadir(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerPorId(long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado editar(Empleado empleado) {
        borrarImagen(empleado.getId());
        return empleadoRepository.save(empleado);
    }

    public void borrar(Long id) {
        borrarImagen(id);
        empleadoRepository.deleteById(id);
    }

    public void borrarImagen(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            fileStorageService.delete(empleado.getImagen());
        }
    }
}

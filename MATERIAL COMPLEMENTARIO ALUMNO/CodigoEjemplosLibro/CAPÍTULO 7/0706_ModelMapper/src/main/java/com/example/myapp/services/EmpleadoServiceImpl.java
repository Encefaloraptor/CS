package com.example.myapp.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.dto.EmpleadoDTO;
import com.example.myapp.repositories.EmpleadoRepository;

@Service
@Primary
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository repositorio;

    @Autowired
    public ModelMapper modelMapper;

    public Empleado añadir(Empleado e) {
        return repositorio.save(e);
    }

    public List<Empleado> obtenerTodos() {
        return repositorio.findAll();
    }

    public Empleado obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Empleado editar(Empleado e) {
        return repositorio.save(e);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    public List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados) {
        List<EmpleadoDTO> listaEmpleadoDTO = new ArrayList<>();
        for (Empleado empleado : listaEmpleados)
            listaEmpleadoDTO.add(modelMapper.map(empleado, EmpleadoDTO.class));
        return listaEmpleadoDTO;
    }
}

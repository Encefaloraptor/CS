package com.example.myapp.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.myapp.domain.Empleado;
import com.example.myapp.dto.EmpleadoDto;
import com.example.myapp.dto.EmpleadoNuevoDto;

@Component
public class EmpleadoDtoConverter {

    @Autowired
    DepartamentoService departamentoService;

    @Autowired
    public ModelMapper modelMapper;

    public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoNuevoDto) {
        return new Empleado(null,
                empleadoNuevoDto.getNombre(),
                empleadoNuevoDto.getEmail(),
                empleadoNuevoDto.getSalario(),
                departamentoService.obtenerPorId(empleadoNuevoDto.getDepartamentoId()));
    }

    public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoEditDto, Long id) {
        Empleado empleado = convertDtoToEmpleado(empleadoEditDto);
        empleado.setId(id);
        return empleado;
    }

    public EmpleadoDto convertEmpleadoToDto(Empleado empleado) {
        return modelMapper.map(empleado, EmpleadoDto.class);
    }

}
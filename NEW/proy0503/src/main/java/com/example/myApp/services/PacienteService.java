package com.example.myApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myApp.domain.Paciente;
import com.example.myApp.dto.NewPacienteDTO;

@Service
public interface PacienteService {
    void add(Paciente paciente);

    void deleteFirst();

    Paciente getFirst();

    public List<Paciente> findAll();

    Paciente buildPaciente(NewPacienteDTO newPacienteDTO);

    double facturar(Paciente paciente);

}

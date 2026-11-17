package com.example.myApp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myApp.config.Tarifas;
import com.example.myApp.domain.Paciente;
import com.example.myApp.domain.PacienteConsulta;
import com.example.myApp.domain.PacienteRecetas;
import com.example.myApp.domain.PacienteRevision;
import com.example.myApp.dto.NewPacienteDTO;

@Service
public class PacienteServiceImplMem implements PacienteService {
    @Autowired
    private Tarifas tarifas;

    private List<Paciente> repositorio = new ArrayList<>();

    public void add(Paciente paciente) {
        repositorio.add(paciente);
    }

    public List<Paciente> findAll() {
        return repositorio;
    }

    public void deleteFirst() {
        if (repositorio.size() > 0)
            repositorio.remove(0);
    }

    public Paciente getFirst() {
        if (repositorio.size() > 0)
            return repositorio.get(0);
        return null;

    }

    public double facturar(Paciente paciente) {
        if (paciente != null)
            return paciente.facturar(tarifas);
        return 0d;

    }

    public Paciente buildPaciente(NewPacienteDTO newPaciente) {
        Paciente paciente;
        // Se crea un paciente dependiendo del tipo de paciente que se haya
        // seleccionado, por lo que los campos
        // varían
        switch (newPaciente.getTipoPaciente()) {
            case 1 -> {
                paciente = new PacienteConsulta();
                ((PacienteConsulta) paciente).setMotivoConsulta(newPaciente.getMotivoConsulta());
            }
            case 2 -> {
                paciente = new PacienteRecetas();
                String[] medicam = newPaciente.getMedicamentos().split(",");
                ((PacienteRecetas) paciente).setMedicamentos(Arrays.asList(medicam));
            }
            case 3 -> {
                paciente = new PacienteRevision();
                ((PacienteRevision) paciente).setFechaVisitaAnterior(newPaciente.getFechaVisitaAnterior());
            }
            default -> {
                return null;
            }
        }
        // Campos comunes
        paciente.setDni(newPaciente.getDni());
        paciente.setNombre(newPaciente.getNombre());
        paciente.setFechaNacimiento(newPaciente.getFechaNacimiento());
        return paciente;
    }
}

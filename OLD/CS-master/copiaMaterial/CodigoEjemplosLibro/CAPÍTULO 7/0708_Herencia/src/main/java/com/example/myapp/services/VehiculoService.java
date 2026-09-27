package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.model.Coche;
import com.example.myapp.model.Moto;
import com.example.myapp.model.Vehiculo;
import com.example.myapp.repositorios.CocheRepository;
import com.example.myapp.repositorios.MotoRepository;
import com.example.myapp.repositorios.VehiculoRepository;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    CocheRepository cocheRepository;

    @Autowired
    MotoRepository motoRepository;

    public List<Coche> obtenerTodosCoches() {
        return cocheRepository.findAll();
    }

    public List<Moto> obtenerTodosMotos() {
        return motoRepository.findAll();
    }

    public Vehiculo añadir(Vehiculo Vehiculo) {
        return vehiculoRepository.save(Vehiculo);
    }

}

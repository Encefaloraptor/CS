package com.example.myapp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

}

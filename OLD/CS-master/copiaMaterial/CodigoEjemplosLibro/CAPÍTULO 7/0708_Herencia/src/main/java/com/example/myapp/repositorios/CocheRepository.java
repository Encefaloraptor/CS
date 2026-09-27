package com.example.myapp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.model.Coche;

//Al emplear estrategia JOINED en la herencia de Vehiculo
//tenemos una tabla para Coche, por lo que podemos tener
//un repositorio.

public interface CocheRepository extends JpaRepository<Coche, Long> {

}

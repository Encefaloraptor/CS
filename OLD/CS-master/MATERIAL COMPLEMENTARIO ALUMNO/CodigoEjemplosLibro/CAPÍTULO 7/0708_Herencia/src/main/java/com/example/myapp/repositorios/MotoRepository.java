package com.example.myapp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.model.Moto;

//Al emplear estrategia JOINED en la herencia de Vehiculo
//tenemos una tabla para Moto, por lo que podemos tener
//un repositorio.

public interface MotoRepository extends JpaRepository<Moto, Long> {

}

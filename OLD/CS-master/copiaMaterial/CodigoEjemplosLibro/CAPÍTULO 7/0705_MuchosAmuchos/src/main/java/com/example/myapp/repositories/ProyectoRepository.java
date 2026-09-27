package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.domain.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}

package com.example.myapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myapp.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}

package com.example.myapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.domain.Departamento;
import com.example.myapp.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByDepartamento(Departamento departamento);

    List<Empleado> findByDepartamentoId(Long departamentoId);
}

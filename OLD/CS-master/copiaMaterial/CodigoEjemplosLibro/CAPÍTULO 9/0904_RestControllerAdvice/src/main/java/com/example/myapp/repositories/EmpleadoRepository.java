package com.example.myapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.myapp.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    // Método derivado por nombre
    List<Empleado> findBySalarioGreaterThanEqualOrderBySalario(double salario);

    // Método a medida con JPQL:
    @Query("select e from Empleado e " +
            "where e.salario > (select avg (e2.salario) from Empleado e2)")
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();
}

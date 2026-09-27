package com.example.myapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "empleados", collectionResourceRel = "empleados")
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}

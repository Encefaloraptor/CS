package com.example.myapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Nomina;

public interface NominaRepository extends JpaRepository<Nomina, Long> {

	// Los dos métodos siguientes no son necesarios ya que al ser una relacion
	// bidireccional,
	// podemos hacer: empleado.getNominas().
	List<Nomina> findByEmpleado(Empleado empleado);

	List<Nomina> findByEmpleadoId(Long empleadoId);
}

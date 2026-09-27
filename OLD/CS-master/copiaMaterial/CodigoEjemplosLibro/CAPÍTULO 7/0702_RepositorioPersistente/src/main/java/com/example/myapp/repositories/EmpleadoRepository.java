package com.example.myapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

        // Métodos derivado por nombre
        List<Empleado> findByNombre(String nombre);

        List<Empleado> findTop3ByNombre(String nombre);

        List<Empleado> findByNombreContainingIgnoreCase(String nombre);

        List<Empleado> findByGenero(Genero genero);

        List<Empleado> findByEmailIsNotNull();

        List<Empleado> findByNombreAndEmail(String nombre, String email);

        List<Empleado> findBySalarioGreaterThanEqualOrderBySalario(double salario);

        List<Empleado> findByNombreOrderByNombreAsc(String nombre);

        List<Empleado> findByNombreOrderByNombreDesc(String nombre);

        // Método a medida con JPQL:
        @Query("select e from Empleado e " +
                        "where e.salario > (select avg (e2.salario) from Empleado e2)")
        List<Empleado> queryBySalarioOverAverage();

        // Parámetros en @Query (numeral)
        @Query("select e from Empleado e where e.nombre=?1 and e.email=?2")
        Empleado obtenerEmpleadoPorNombreYEmailnum(String nombre, String email);

        // Parámetros en @Query (nominal)
        @Query("select e from Empleado e where e.nombre=:nombre and e.email=:email")
        Empleado obtenerEmpleadoPorNombreYEmailnom(@Param("nombre") String nombre,
                        @Param("email") String email);

        // Consulta de agregación (no se puede hacer con método derivado por nombre)
        @Query("select sum(e.salario) from Empleado e where e.genero=:genero")
        Optional<Double> querySumSalarioByGenero(@Param("genero") Genero genero);

        // Actualizaciones en @Query
        @Modifying
        @Query("update Empleado e set e.email = :email where e.id = :id")
        int updateEmailById(@Param("id") Integer id, @Param("email") String email);

}

package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;
import com.example.myapp.repositories.EmpleadoRepository;

@Service
// Si hubiese más implementaciones de EmpleadoService, añadiríamos:
// @Primary
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;

    public List<Empleado> obtenerTodos() {
        return repositorio.findAll();
        // si queremos que el resultado esté ordenado por un atributo
        // usaremos la versión de findAll que incorpora Sort, ejemplos:
        // return repositorio.findAll (Sort.by(Sort.Direction.ASC, "email"));
        // return repositorio.findAll (Sort.by(Sort.Direction.DESC, "salario"));
    }

    public Empleado obtenerPorId(long id) throws RuntimeException {
        return repositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Empleado no encontrado"));
        // findById de JpaRepository devuelve un Optional. Para simplificar,
        // y que el servicio siga devolviendo Empleado y no Optional<Empleado>
        // hacemos que si no lo encuentra lance una excepción. La otra opción sería
        // que devolviese null:
        // return repositorio.findById(id).orElse(null);
    }

    public Empleado añadir(Empleado empleado) {
        // añadiríamos lógica de negocio. P.ej: guardar si salario > 18000
        return repositorio.save(empleado);
    }

    public Empleado editar(Empleado empleado) throws RuntimeException {
        obtenerPorId(empleado.getId()); // lanza excepción si no existe
        return repositorio.save(empleado);
    }

    public void borrar(Long id) throws RuntimeException {
        obtenerPorId(id); // lanza excepción si no existe
        repositorio.deleteById(id);
    }

    public List<Empleado> obtenerEmpleadosSalarioMayor(double salario) {
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }

    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.queryBySalarioOverAverage();
    }

    public Double obtenerSumaSalariosPorGenero(Genero genero) {
        return repositorio.querySumSalarioByGenero(genero).orElse(0d);
    }
}

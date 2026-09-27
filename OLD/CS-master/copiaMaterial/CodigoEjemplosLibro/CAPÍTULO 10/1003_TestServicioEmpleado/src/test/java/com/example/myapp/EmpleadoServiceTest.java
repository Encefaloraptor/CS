package com.example.myapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myapp.domain.Empleado;
import com.example.myapp.domain.Genero;
import com.example.myapp.repositories.EmpleadoRepository;
import com.example.myapp.services.EmpleadoServiceImpl;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoServiceTest {

    @InjectMocks
    EmpleadoServiceImpl empleadoService;
    
    @Mock
    EmpleadoRepository empleadoRepository;
    
    ArrayList<Empleado> mockList;

    @BeforeAll
    public void init() {
        mockList = new ArrayList<>();
        mockList.add(new Empleado(1L, "test1", "test1@mail.com", 30000d, true, Genero.MASCULINO));
        mockList.add(new Empleado(2L, "test2", "test2@mail.com", 40000d, false, Genero.FEMENINO));
        mockList.add(new Empleado(3L, "test3", "test3@mail.com", 45000d, true, Genero.OTROS));
    }

    @Test
    public void obtenerTodosTest() {
        when(empleadoRepository.findAll()).thenReturn(mockList);
        List<Empleado> empList = empleadoService.obtenerTodos();
        assertEquals(3, empList.size());
        verify(empleadoRepository, times(1)).findAll();
    }

    @Test
    // el mock de findAll devuelve 3 filas, pero el método obtenerTodos solo se
    // queda con dos. No toma a "test2" porque no está en activo.
    public void obtenerActivosTest() {
        when(empleadoRepository.findAll()).thenReturn(mockList);
        List<Empleado> empList = empleadoService.obtenerActivos();
        assertEquals(2, empList.size());
        verify(empleadoRepository, times(1)).findAll();
    }

    @Test
    public void obtenerPorIdTest() {
        when(empleadoRepository.findById(1L)).thenReturn(Optional.of(mockList.get(0)));
        Empleado empleado = empleadoService.obtenerPorId(1L);
        assertEquals("test1", empleado.getNombre());
        assertEquals("test1@mail.com", empleado.getEmail());
        assertEquals(30000, empleado.getSalario());
    }

    @Test
    public void añadirTest_ok() {
        Empleado empleadoNew = new Empleado(4L, "test4", "test4@mail.com", 55000d, true, Genero.MASCULINO);
        when(empleadoRepository.save(empleadoNew)).thenReturn(empleadoNew);
        Empleado insertado = empleadoService.añadir(empleadoNew);
        assertEquals("test4", insertado.getNombre());
        verify(empleadoRepository, times(1)).save(empleadoNew);
    }

    @Test
    public void añadirTest_ko() {
        Empleado empleadoNew = new Empleado(5L, "test5", "test5@mail.com", 100d, true, Genero.MASCULINO);
        // when(empleadoRepository.save(empleadoNew)).thenReturn(empleadoNew);
        assertThrows(RuntimeException.class, () -> {
            empleadoService.añadir(empleadoNew);
        });
        verify(empleadoRepository, times(0)).save(empleadoNew);
    }

    @Test
    public void borrarTest_ok() {
        when(empleadoRepository.findById(1L))
                .thenReturn(Optional.of(mockList.get(0)));
        empleadoService.borrar(1L);
        verify(empleadoRepository, times(1)).findById(1L);
        verify(empleadoRepository, times(1)).deleteById(1L);
    }

    @Test
    public void borrarTest_notFound() {
        when(empleadoRepository.findById(999L)).thenReturn(Optional.empty());
        // when(empleadoRepository.findById(999L)).thenReturn(Optional.ofNullable(null));
        assertThrows(RuntimeException.class, () -> {
            empleadoService.borrar(999L);
        });
        verify(empleadoRepository, times(1)).findById(999L);
        verify(empleadoRepository, times(0)).deleteById(999L);
    }
}

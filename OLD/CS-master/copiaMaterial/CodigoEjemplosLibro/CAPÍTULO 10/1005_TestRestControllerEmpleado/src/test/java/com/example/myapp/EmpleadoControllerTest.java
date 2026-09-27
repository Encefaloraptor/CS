package com.example.myapp;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
//import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.myapp.controllers.EmpleadoController;
import com.example.myapp.domain.Empleado;

import com.example.myapp.services.EmpleadoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoControllerTest {

    // VARIABLES GLOBALES PARA TESTING
    List<Empleado> mockList;
    Empleado empleadoSinId, empleadoConId;

    @InjectMocks
    private EmpleadoController empleadoController;

    @MockitoBean
    private EmpleadoService empleadoService;

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    void initTest() {
        mockList = new ArrayList<>();
        mockList.add(new Empleado(1L, "Pepe", "pepe@mail.com", 30000d));
        mockList.add(new Empleado(2L, "Juan", "juan@mail.com", 45000d));
        empleadoSinId = new Empleado(null, "Eva", "eva@mail.com", 35000d);
        empleadoConId = new Empleado(3L, "Eva", "eva@mail.com", 35000d);
    }

    @Test
    public void getAllEmpleadoTest() throws Exception {
        when(empleadoService.obtenerTodos()).thenReturn(mockList);
        mockMvc.perform(get("/empleado")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Pepe")))
                .andExpect(jsonPath("$[0].email", is("pepe@mail.com")))
                .andExpect(jsonPath("$[0].salario", is(30000d)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nombre", is("Juan")))
                .andExpect(jsonPath("$[1].email", is("juan@mail.com")))
                .andExpect(jsonPath("$[1].salario", is(45000d)));
    }

    @Test
    public void getOneEmpleadoTest() throws Exception {
        when(empleadoService.obtenerPorId(1L)).thenReturn(mockList.get(0));
        mockMvc.perform(get("/empleado/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Pepe")))
                .andExpect(jsonPath("$.salario", is(30000d)));
    }

    @Test
    public void addEmpleadoTest() throws Exception {
        when(empleadoService.añadir(empleadoSinId)).thenReturn(empleadoConId);
        mockMvc.perform(post("/empleado")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(empleadoSinId)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.nombre", is("Eva")))
                .andExpect(jsonPath("$.salario", is(35000d)));
    }

    @Test
    public void deleteOneEmpleadoTest() throws Exception {
        when(empleadoService.obtenerPorId(1L)).thenReturn(mockList.get(0));
        //doNothing().when(empleadoService).borrar(1L);  //no es necesario 
        mockMvc.perform(delete("/empleado/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }
}

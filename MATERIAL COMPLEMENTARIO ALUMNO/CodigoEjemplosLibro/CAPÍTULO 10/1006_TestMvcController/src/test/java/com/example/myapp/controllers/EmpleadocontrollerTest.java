package com.example.myapp.controllers;

//importa:allOf, equalTo, hasItem,hasProperty, hasSize, instaceOf… 
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;
//importa: get, post…
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//importa model, view, status, redirectedUrl…
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.myapp.domain.Empleado;
import com.example.myapp.services.EmpleadoService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class EmpleadocontrollerTest {

    List<Empleado> mockList; // variables que emplearemos en varios tests
    Empleado empleadoSinId, empleadoConId;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks // clase a testar con servicio dependiente mockeado
    EmpleadoController empleadoController;

    @MockitoBean // clase/interfaz falseada con cláusulas when
    EmpleadoService empleadoService;

    @BeforeAll
    void initTest() {
        mockList = new ArrayList<>();
        mockList.add(new Empleado(1L, "Pepe", "pepe@mail.com", 30000d));
        mockList.add(new Empleado(2L, "Juan", "juan@mail.com", 45000d));
        empleadoSinId = new Empleado(null, "Eva", "eva@mail.com", 35000d);
        empleadoConId = new Empleado(3L, "Eva", "eva@mail.com", 35000d);
    }

    @Test
    void addElementTest() throws Exception {
        when(empleadoService.añadir(empleadoSinId)).thenReturn(empleadoConId);
        mockMvc.perform(post("/nuevo/submit")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("nombre", "Eva")
                .param("email", "eva@mail.com")
                .param("salario", "35000"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    } // también es posible: .andExpect(redirectedUrlPattern("/myURL/*")

    @Test
    void listElementsTest() throws Exception {
        when(empleadoService.obtenerTodos()).thenReturn(mockList);
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("listView"))
                .andExpect(model().attributeExists("listaEmpleados"))
                .andExpect(model().attribute("listaEmpleados", instanceOf(ArrayList.class)))
                .andExpect(model().attribute("listaEmpleados", hasSize(2)))
                .andExpect(model().attribute("listaEmpleados", hasItem(allOf(
                        hasProperty("nombre", equalTo("Juan")),
                        hasProperty("salario", equalTo(45000d))))))
                .andExpect(model().attribute("listaEmpleados", hasItem(allOf(
                        hasProperty("nombre", equalTo("Pepe")),
                        hasProperty("salario", equalTo(30000d))))));
    }
}

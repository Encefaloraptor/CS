package com.demo.myapp.controllers;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
//get, post, put.. .
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.myapp.services.CalculosService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class CalculosControllerTest {
    @InjectMocks
    CalculosController calculosController;

    @Mock
    CalculosService calculosService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listElementsTest() throws Exception {

        when(calculosService.esPrimo(5)).thenReturn(true);

        mockMvc.perform(get("/calculos/primo?numero=5"))
                .andExpect(status().isOk())
                .andExpect(view().name("esPrimoView"))
                .andExpect(model().attributeExists("result"))
                .andExpect(model().attribute("result", is(true)));
    }

}

package com.demo.myapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.myapp.services.CalculosService;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CalculosServiceTest {
    @Autowired
    CalculosService calculosService;

    @Test
    public void esPrimoTest() {
        assertEquals(calculosService.esPrimo(7), true);
        assertEquals(calculosService.esPrimo(8), false);
        assertThrows(IllegalArgumentException.class, () -> calculosService.esPrimo(-1));
    }

    @Test
    public void hipotenusaTest() {
        assertEquals(calculosService.hipotenusa(7d, 2d), 7.28d, 0.01f);
    }
}

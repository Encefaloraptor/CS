package com.example.myapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS) // import org.junit.jupiter.api
public class MainServiceTest {

    @Autowired
    private MainService mainService;
    
    Integer a, b;

    @BeforeEach // antes de cada test inicia las variables
    public void init() {
        a = 3;
        b = 2;
    }

    @Test
    public void sumarTest_ok() {
        assertEquals(5, mainService.sumar(a, b));
    }

    @Test
    public void sumarTest_except() {
        a = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            mainService.sumar(a, b);
        });
    }

    @Test
    public void dividirTest() {
        assertEquals(1.5f, mainService.dividir(a, b));
    }
}
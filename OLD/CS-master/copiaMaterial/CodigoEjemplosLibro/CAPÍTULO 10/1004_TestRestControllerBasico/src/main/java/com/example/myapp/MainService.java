package com.example.myapp;

import org.springframework.stereotype.Service;

@Service
public class MainService {
    public Integer sumar(Integer op1, Integer op2) {
        if (op1 > 0 && op2 > 0)
            return op1 + op2;
        else
            throw new IllegalArgumentException(
                    "Los dos operandos deben ser positivos");
    }

    public Float dividir(Integer op1, Integer op2) {
        if (op2 != 0)
            return (float) op1 / op2;
        else
            throw new IllegalArgumentException(
                    "No se puede dividir por cero");
    }
}
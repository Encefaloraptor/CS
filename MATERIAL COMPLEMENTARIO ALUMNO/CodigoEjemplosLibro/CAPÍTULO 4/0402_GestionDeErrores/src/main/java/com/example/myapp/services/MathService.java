package com.example.myapp.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {
  public Double calcularHipotenusa(Double cat1, Double cat2) throws RuntimeException {
    if (cat1 <= 0 || cat2 <= 0)
      throw new RuntimeException("Error en parámetros de entrada");
    return Math.hypot(cat1, cat2);
  }
}

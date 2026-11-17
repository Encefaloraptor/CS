package com.demo.myapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculosServiceImpl implements CalculosService {

    public boolean esPrimo(int num) throws RuntimeException {
        if (num < 0)
            throw new RuntimeException("El número no puede ser negativo");
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public Double hipotenusa(Double catX, Double catY) throws RuntimeException {
        if (catX < 0 || catY < 0)
            throw new RuntimeException("Los catetos no pueden ser negativos");
        return Math.hypot(catX, catY);
    }

    public List<Integer> divisores(int n) {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                lista.add(i);
        }
        lista.add(n);
        return lista;
    }
}

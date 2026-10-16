package com.example.ejercicios_tema_2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculosServiceImpl implements CalculosInterface {

    @Override
    public Double hipotenusa(String cateto1String, String cateto2String) {

        double cat1 = Double.parseDouble(cateto1String);
        double cat2 = Double.parseDouble(cateto2String);

        if (cat1 >= 1000 || cat2 >= 1000) {
            throw new RuntimeException("No se admiten números mayores que 1000");
        }

        if (cat1 <= 0 || cat2 <= 0) {
            throw new RuntimeException("No se admiten números menores que 0");
        }

        double resultado = Math.sqrt(Math.pow(cat1, 2) + Math.pow(cat2, 2));

        return resultado;
    }

    @Override
    public List<Integer> divisores(int num) {
        List<Integer> divisores = new ArrayList<>();
        if (num < 0) throw new RuntimeException("El número tiene que ser mayor que 0");
        int i = 2;
        while(i<=(num/2)){
            if(num%i==0) divisores.add(i);
            i++;
        }
        return divisores;
    }
    
    @Override
    public boolean isPrimo(int num) {
        return divisores(num).isEmpty();
    }
}

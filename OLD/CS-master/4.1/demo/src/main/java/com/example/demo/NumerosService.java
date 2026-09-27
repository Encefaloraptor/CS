package com.example.demo;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class NumerosService {
    
    private final Set<Integer> lista = new LinkedHashSet<>();
    private final Random random = new Random();

    public void addNumeroAleatorio() {
        boolean añadido;
        do {
            añadido = lista.add(random.nextInt(100) + 1);
        } while (!añadido);
    }

    public void eliminarNumero(Integer numero) {
        lista.remove(numero);
    }

    public Set<Integer> getLista() {
        return lista;
    }

    public int getCantidad() {
        return lista.size();
    }
}

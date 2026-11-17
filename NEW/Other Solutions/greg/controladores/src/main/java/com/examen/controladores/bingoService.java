package com.examen.controladores;

import java.util.TreeSet;

public interface bingoService {
    boolean probaNumeros(Integer numeros) throws Exception;
    boolean probaMayores50(Integer numeros, Integer mayores50) throws Exception;
    TreeSet<Integer> createCarton(Integer numeros, Integer mayores50);
}
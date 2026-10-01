package com.example.ejercicios_tema_2.service;

import java.util.List;

public interface CalculosInterface {

    abstract Double hipotenusa(String cateto1String, String cateto2String);

    abstract List<Integer> divisores(int num);

    abstract boolean isPrimo(int num) ;
    
}

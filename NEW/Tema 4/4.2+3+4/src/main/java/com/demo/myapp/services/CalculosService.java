package com.demo.myapp.services;

import java.util.List;

public interface CalculosService {

   boolean esPrimo(int num) throws RuntimeException;

   Double hipotenusa(Double catX, Double catY) throws RuntimeException;

   List<Integer> divisores(int n);
}

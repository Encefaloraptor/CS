package com.diego.curras.services;
import org.springframework.stereotype.Service;

@Service 
public class MathService { 
    public Double calcularHipotenusa (Double cat1, Double cat2) throws RuntimeException { 
        if (cat1 <= 0 || cat2 <= 0  ){
            throw new RuntimeException("Error en parámetros de entrada, al menos alguno de los catetos es igual o menor a cero");
        }else if(cat1 > 1000 || cat2 > 1000){
            throw new RuntimeException("Error en parámetros de entrada, al menos alguno de los catetos es mayor a 1000");
        }
        return Math.hypot(cat1, cat2);      
    } 
} 
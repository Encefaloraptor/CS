package com.examen.controladores;

import java.util.Random;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service 
public class bingoServiceImpl implements bingoService {

    private Random random = new Random();
    private TreeSet<Integer> listaCarton = new TreeSet<>();
    private boolean cartonGenerado = false;

    public boolean  probaNumeros(Integer numeros) throws RuntimeException{
        if (numeros == null || numeros < 8 || numeros > 12) {
            throw new RuntimeException("numeros debe estar entre 8 y 12");
        }
        return true;
    }

    public boolean probaMayores50(Integer numeros, Integer mayores50) throws RuntimeException{
        if (mayores50 == null || mayores50 < 0 || mayores50 > numeros) {
            throw new RuntimeException("mayores50 fuera de rango");
        }
        return true;
    }

    public TreeSet<Integer> createCarton(Integer numeros, Integer mayores50){
        if (probaNumeros(numeros) && probaMayores50(numeros, mayores50) && !cartonGenerado){
            int countBajo = numeros - mayores50;
            do {
                listaCarton.add(random.nextInt(1, 50));
            } while (listaCarton.size() < countBajo);

            do {
                listaCarton.add(random.nextInt(50, 100));
            } while (listaCarton.size() < countBajo + mayores50);

            cartonGenerado = true;
        }
        return listaCarton;
    }

   
    public void eliminarNumero(int numero) {
        listaCarton.remove(numero);
    }


    public void reiniciarCarton() {
        listaCarton.clear();
        cartonGenerado = false;
    }
}
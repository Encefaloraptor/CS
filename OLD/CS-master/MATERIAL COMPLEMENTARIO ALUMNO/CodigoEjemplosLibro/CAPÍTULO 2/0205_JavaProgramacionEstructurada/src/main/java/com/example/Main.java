package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Estructura condicional:
        System.out.println("Introduce la temperatura: ");
        int temperatura = scanner.nextInt();
        if (temperatura > 25)
            System.out.println("A la playa!!!");
        else
            System.out.println("A la montaña!!!");

        // switch
        System.out.println("Introduce un mes (1-12): ");
        int numMes = scanner.nextInt();
        int numDias = 0;
        boolean mesLargo = false;

        // switch clásico
        // switch (numMes) {
        // case 1, 3, 5, 7, 8, 10, 12 :
        // numDias = 31;
        // mesLargo = true;
        // break;
        // case 2 : numDias = 28; break;
        // case 4, 6, 9, 11 : numDias = 30;
        // }

        // ruled switch
        switch (numMes) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                numDias = 31;
                mesLargo = true;
            }
            case 2 -> numDias = 28;
            case 4, 6, 9, 11 -> numDias = 30;
        }
        System.out.printf("El mes introducido tiene %d días\n", numDias);
        if (mesLargo)
            System.out.println("...y es un mes largo.");

        // Estructura repetitiva:
        int cont;
        for (cont = 1; cont <= 10; cont++) {
            System.out.println("Bucle de 10 iteraciones");
        }

        cont = 1;
        while (cont <= 10) {
            System.out.println("otro bucle de 10 iteraciones");
            cont++;
        }

        cont = 1;
        do {
            System.out.println("el último bucle de 10 iteraciones");
            cont++;
        } while (cont <= 10);

        // Funciones:
        System.out.println("Introduce un número");
        int numero = scanner.nextInt();
        boolean resultado = esPar(numero);
        if (resultado)
            System.out.println("El número es par");
        else
            System.out.println("El número es impar");

        // Enumeraciones
        for (DiaSemana dia : DiaSemana.values()) {
            if (dia == DiaSemana.DOMINGO)
                System.out.print("FESTIVO:");
            System.out.println(dia);
        }

        // Excepciones
        System.out.println("Introduce dividendo");
        int dividendo = scanner.nextInt();
        System.out.println("Introduce divisor");
        int divisor = scanner.nextInt();
        double cociente = 0d;
        try {
            cociente =  dividendo / divisor; // instrucción que puede provocar excepción
        } catch (Exception e) {
            cociente = 0; // si se produce excepción
        } finally {
            System.out.println("Resultado= " + cociente);
        }

    }

    static boolean esPar(int num) {
        if (num % 2 == 0)
            return true;
        else
            return false;
    }
}
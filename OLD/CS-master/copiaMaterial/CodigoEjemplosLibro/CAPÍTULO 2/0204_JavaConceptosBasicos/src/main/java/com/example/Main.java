package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Variables locales:
        int a, A, edad; // declara tres variables enteras: a, A, y edad
        int d = 3, e, f1 = 5; // tres enteros más, inicializando d y f1
        byte z = 22; // inicializa z.
        double pi = 3.14159; // declara una aproximación de PI
        char x = 'x'; // la variable x tiene el valor ‘x’

        // asignacion con casting:
        double numeroDecimal = 9.78;
        int numeroEntero = (int) numeroDecimal;

        // cadenas
        String cad1 = "Hola mundo";
        String cad2 = new String("Hola Java");
        int pos1 = cad1.indexOf('a');
        int pos2 = cad2.indexOf('z');

        //operadores
        edad=20;
        edad++;
        a=30;
        a+=10;

        //salida por consola:
        System.out.println("La variable 'edad' es igual a " + edad);
        System.out.printf("La variable 'a' es igual a %d\n", a);
        System.out.println("La cadena "+ "contiene la letra 'a' en la posición " + pos1);

        //Entrada de  datos por consola
        Scanner sc = new Scanner (System.in);
        System.out.println("Introduce un número: ");
        int num= sc.nextInt();
        System.out.println("Has introducido el numero " + num);
        sc.close();
    }
}
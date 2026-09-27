package com.example;

/* Este es un programa ejemplo
   de aplicación de consola en Java
 */
import java.util.Scanner;

public class Main {

    static Scanner teclado; // variable global

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        int n;
        do {
            System.out.println("Introduce un número (0 para terminar):");
            n = teclado.nextInt();
            if (n != 0) {
                boolean res = esPar(n);
                if (res) // igal a : if (res==true)
                    System.out.println(n + " es par");
                else
                    System.out.println(n + " es impar");
            }
        } while (n != 0);
    }

    static boolean esPar(int num) {
        if (num % 2 == 0)
            return true;
        return false;
    }
}
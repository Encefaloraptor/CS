package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Uso de la clase Circulo
        System.out.println("Introduce radio del círculo: ");
        double radio1 = sc.nextDouble();
        Circulo circ1 = new Circulo(radio1);
        double area = circ1.calcularSuperficie();
        System.out.println("El área del círculo es: " + area);

        // Uso de la clase Random
        Random random = new Random();
        int dado = random.nextInt(1, 7);
        System.out.println("\n\nHe tirado el dado y ha salido:" + dado);

        // Uso de la clase Math (método estáticos)

        double potencia = Math.pow(2, 10);
        System.out.println("\n\n 2 elevado a 10 es: " + potencia);

        // Uso de la clase LocalDate / LocalDateTime

        LocalDate fecha1 = LocalDate.now();
        System.out.println("\n\nHoy es día: " + fecha1);
        LocalDate fecha2 = LocalDate.of(2024, 11, 29);
        System.out.println("Fecha creada con of: " + fecha2);
        LocalDate fecha3 = LocalDate.parse("1990-12-31");
        System.out.println("Fecha creada con parse: " + fecha3);

        LocalTime hora4 = LocalTime.parse("08:30");
        System.out.println("Hora creada con parse: " + hora4);

        LocalDateTime fechahora5 = LocalDateTime.parse("2024-12-31T11:25");
        System.out.println("Fecha/Hora creada con parse: " + fechahora5);

    }
}
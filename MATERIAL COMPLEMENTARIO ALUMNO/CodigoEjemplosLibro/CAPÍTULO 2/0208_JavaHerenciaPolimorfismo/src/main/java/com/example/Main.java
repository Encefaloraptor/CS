package com.example;

public class Main {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado ();
        empleado1.nombre="Pepe";
        empleado1.salario= 40000f;


        //polimorfismo
        Empleado empleado2 = new Directivo ();
        empleado2.nombre="Ana";
        empleado2.salario= 90000f;
        Directivo directivo = (Directivo) empleado2;
        directivo.bonus= 3000f;

        System.out.println ("Salario empleado1: " + empleado1.calcularSalarioNeto(0.1f));
        System.out.println ("Salario empleado2 (directivo): " + empleado2.calcularSalarioNeto(0.1f));
        System.out.println ("Bonus empleado2 :" + ((Directivo)empleado2).bonus);

    }
}
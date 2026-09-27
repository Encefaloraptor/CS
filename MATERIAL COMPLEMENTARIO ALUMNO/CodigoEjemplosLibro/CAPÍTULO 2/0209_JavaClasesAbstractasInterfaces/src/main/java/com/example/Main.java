package com.example;

public class Main {
    public static void main(String[] args) {

        FiguraAbstracta fig1 = new Triangulo(3,2);
        System.out.println("Area del triángulo:" +fig1.calcularSuperficie());
        fig1 = new Rectangulo(3,2);
        System.out.println("Area del Rectángulo:" +fig1.calcularSuperficie()); 

        FiguraInterface fig2 = new Circulo(3f);
        System.out.println("Area del círculo:" +fig2.calcularSuperficie());
    }
}
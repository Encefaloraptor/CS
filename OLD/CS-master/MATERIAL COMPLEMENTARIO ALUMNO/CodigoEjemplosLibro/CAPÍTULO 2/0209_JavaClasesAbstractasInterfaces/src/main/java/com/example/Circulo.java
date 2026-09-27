package com.example;

public class Circulo implements FiguraInterface {
    public float radio;

    Circulo(float radio) {
        this.radio = radio;
    }

    public float calcularSuperficie (){
        return this.radio * this.radio * (float)Math.PI;
    }
}

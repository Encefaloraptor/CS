package com.example;

public abstract class FiguraAbstracta {
    public float alto;
    public float ancho;

    public FiguraAbstracta(float alto, float ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public abstract float calcularSuperficie();

}

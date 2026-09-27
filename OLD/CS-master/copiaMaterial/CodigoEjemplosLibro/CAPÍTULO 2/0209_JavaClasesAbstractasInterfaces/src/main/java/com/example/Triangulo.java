package com.example;

public class Triangulo extends FiguraAbstracta{
 
    public Triangulo (float alto, float ancho){
           super(alto, ancho);
    }
    public float calcularSuperficie (){
        return this.alto * this.ancho / 2;
        }
}

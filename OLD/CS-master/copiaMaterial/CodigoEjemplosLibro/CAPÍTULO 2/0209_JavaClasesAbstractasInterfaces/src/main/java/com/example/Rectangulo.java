package com.example;

public class Rectangulo extends FiguraAbstracta{
 
    public Rectangulo (float alto, float ancho){
           super(alto, ancho);
    }
    public float calcularSuperficie (){
        return this.alto * this.ancho;
        }
}

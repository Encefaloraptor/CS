package com.example;

public class Empleado {
    public String nombre;
    public Float salario;

    public float calcularSalarioNeto(float impuesto) {
        return this.salario - (this.salario * impuesto);
    }
}
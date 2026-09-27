package com.example;

public class Directivo extends Empleado {
    public Float bonus;

    @Override
    public float calcularSalarioNeto(float impuesto) {
        return (this.salario + this.bonus) - (this.salario * impuesto);
    }
}

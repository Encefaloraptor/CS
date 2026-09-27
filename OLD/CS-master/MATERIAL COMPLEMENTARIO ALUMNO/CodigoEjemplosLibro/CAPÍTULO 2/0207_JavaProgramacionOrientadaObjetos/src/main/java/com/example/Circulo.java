package com.example;

public class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularCircunferencia (){
       return 2 * Math.PI * this.radio;
    }
    
    public double calcularSuperficie (){
        return Math.PI * this.radio * this.radio;
    }

    public double calcularDiametro (){
        return 2 * this.radio;
    }
  
    @Override
    public String toString() {
        return "Circulo [radio=" + radio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(radio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Circulo other = (Circulo) obj;
        if (Double.doubleToLongBits(radio) != Double.doubleToLongBits(other.radio))
            return false;
        return true;
    }

    
}

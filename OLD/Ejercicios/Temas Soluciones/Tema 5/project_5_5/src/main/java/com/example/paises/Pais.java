package com.example.paises;

public class Pais {
    private String nombre;
    private String capital;
    private int poblacion;

    public String getNombre(){
        return nombre;
    }

    public String getCapital(){
        return capital;
    }

    public int getPoblacion(){
        return poblacion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCapital(String capital){
        this.capital = capital;
    }

    public void setPoblacion(int poblacion){
        this.poblacion = poblacion;
    }

    public Pais(){
    }

    public Pais(String nombre, String capital, int poblacion){
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
    }
}

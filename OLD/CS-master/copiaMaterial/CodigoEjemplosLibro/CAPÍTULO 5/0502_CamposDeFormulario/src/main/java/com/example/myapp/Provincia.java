package com.example.myapp;

public class Provincia {
    private Long id;
    private String nombre;

    public Provincia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Provincia [id=" + id + ", nombre=" + nombre + "]";
    }
    
    
}

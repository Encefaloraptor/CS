package com.example.myapp;

public class FormInfo {
    private String nombre;
    private String telefono;
    private String asunto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public String toString() {
        return "FormInfo [nombre=" + nombre + ", telefono=" + telefono + ", asunto=" + asunto + "]";
    }

}

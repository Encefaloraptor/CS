package com.example.demo.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FormInfo {

    @NotBlank(message = "Introduce un nombre")
    private String nombre;
     @NotBlank(message = "Introduce un DNI")
    private String dni;
    @NotBlank(message = "Introduce una correo electrónico")
    @Email(message = "Formato de correo electrónico inválido")
    private String email;
    @NotBlank(message = "Introduce una dirección")
    private String direccion;
    private boolean fotoFirmada;
    private boolean entradaVIP;
    private boolean bufanda;
    @AssertTrue(message = "Acepta los términos y condiciones")
    private boolean condiciones;
    private String nombreFicheroString;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public boolean isFotoFirmada() {
        return fotoFirmada;
    }
    public void setFotoFirmada(boolean fotoFirmada) {
        this.fotoFirmada = fotoFirmada;
    }
    public boolean isEntradaVIP() {
        return entradaVIP;
    }
    public void setEntradaVIP(boolean entradaVIP) {
        this.entradaVIP = entradaVIP;
    }
    public boolean isBufanda() {
        return bufanda;
    }
    public void setBufanda(boolean bufanda) {
        this.bufanda = bufanda;
    }
    public boolean isCondiciones() {
        return condiciones;
    }
    public void setCondiciones(boolean condiciones) {
        this.condiciones = condiciones;
    }
    public String getNombreFicheroString() {
        return nombreFicheroString;
    }
    public void setNombreFicheroString(String nombreFicheroString) {
        this.nombreFicheroString = nombreFicheroString;
    }

    @Override
    public String toString() {
        return "El formulario de: " + this.getNombre() + ". Con DNI: " + this.getDni().toUpperCase() 
        + ". Con email: " + this.getEmail() + ". Dirección: " + this.getDireccion() + 
        ". Foto firmada: " + this.isFotoFirmada() + ". Entrada VIP: " + this.isEntradaVIP() 
        + ". Bufanda: " + this.isBufanda() + ".";
    }
}

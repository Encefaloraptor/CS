package com.example;

import lombok.NonNull;
import lombok.Getter;

@Getter
class Usuario {
    private String nombre;
    private String email;

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }
}

public class Ej17_13 {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        try {
            u.setNombre(null);
            u.setNombre("Pedro");
            u.setEmail("p@uvigo.gal");
        } catch (NullPointerException e) {
            System.out.println("Error: asignación de nulo");
        }
        System.out.println("Nombre: " + u.getNombre());
        System.out.println("Email: " + u.getEmail());
    }
}

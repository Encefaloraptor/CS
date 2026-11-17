package com.example;

import lombok.*;

@Getter
@AllArgsConstructor

class Usuario {
    private long id;
    private String nombre;
    private String apellidos;

    public String getNombre() {
        return this.nombre.toUpperCase();
    }
}

public class Ej17_11 {
    public static void main(String[] args) {
        Usuario u1 = new Usuario(1, "Brais", "Sanz");
        System.out.println(u1.getNombre());
        System.out.println(u1.getApellidos());
    }
}

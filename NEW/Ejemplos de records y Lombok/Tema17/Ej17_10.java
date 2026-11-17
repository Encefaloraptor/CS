package com.example;

import java.util.ArrayList;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode

class Usuario {
    private long id;
    private String nombre;
    private String apellidos;
    private ArrayList<String> telefonos;

    void nuevoTelefono(String telefono) {
        if (telefonos == null) {
            telefonos = new ArrayList<>();
        }
        telefonos.add(telefono);
    }
}

public class Ej17_10 {
    public static void main(String[] args) {

        Usuario u1 = new Usuario(1, "Juan", "López", null);
        u1.nuevoTelefono("66661111");
        u1.nuevoTelefono("22222");

        Usuario u2 = new Usuario(1, "Juan", "López", null);
        u2.nuevoTelefono("22222");
        u2.nuevoTelefono("66661111");

        if (u1.equals(u2)) {
            System.out.println("Usuarios iguales");
        } else {
            System.out.println("Usuarios diferentes");
        }
    }
}

package com.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = { "nombre", "apellidos" })

class Usuario {
    private long id;
    private String nombre;
    private String apellidos;
}

public class Ej17_9 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Miguel", "Cao");
        Usuario usuario2 = new Usuario(2, "Miguel", "Cao");
        Usuario usuario3 = usuario;
        if (usuario.equals(usuario2))
            System.out.println("usuarios iguales");
        else
            System.out.println("usuarios distintos");
        System.out.println("usuario.hashCode() = " +
                usuario.hashCode());
        System.out.println("usuario3.hashCode() = " +
                usuario3.hashCode());
    }
}

package com.example;

import lombok.*;

@AllArgsConstructor
@Data
@Value//Para que sea inmutable por lo que no se puede usar sus setters
class Usuario {
    long id;
    String nombre;
    String apellidos;
}
public class Ej17_12 {
    public static void main(String[] args) {

        Usuario usuario = new Usuario(1L, "Brais", "Cao");
        System.out.println(usuario.toString());
        usuario.setNombre("Pepe");
        System.out.println(usuario.toString());
    }
}

package com.example;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
class Usuario {
    private final String nombre;
    private final String email;
    @With
    private final boolean autenticado;
}

public class Ej17_14 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Ana", "ana@mail.com", false);
        System.out.println(usuario);
        Usuario uAuten = usuario.withAutenticado(true);
        System.out.println(uAuten);
    }
} // imprescidible constructor por ser clase inmutable

package com.example;

import lombok.*;

@NoArgsConstructor(force = true)
@ToString
class Usuario {
    private final long id;
    private final String nombre;
    @NonNull
    private final String email;
}

public class Ej17_15 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        System.err.println(usuario);
    }
}

// como se puede ver en el mensaje mostrado, no se
// respeta la anotación @NonNull del campo email:

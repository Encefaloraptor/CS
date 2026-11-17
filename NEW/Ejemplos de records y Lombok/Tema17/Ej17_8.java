package com.example;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor(staticName = "of")

class Usuario {
    private long id;
    @NonNull
    private String nombre;
    @NonNull
    private String apellidos;
}

public class Ej17_8 {
    public static void main(String[] args) {
        Usuario usuario = Usuario.of(1L, "Brais", "Cao Estévez");
        System.out.println(usuario.toString());
    }
}

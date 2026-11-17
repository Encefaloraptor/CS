// crea el constructor con el menor número de argumentos
// necesarios: los necesarios para los campos final y
// @NonNull

package com.example;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
class Usuario {
    private final long id;
    @NonNull
    private String nombre;
    private String email;
}

public class Ej17_7 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1L, "Miguel");
        System.out.println(usuario);
        usuario.setNombre("Pedro");
        System.out.println(usuario.toString());
    }
}

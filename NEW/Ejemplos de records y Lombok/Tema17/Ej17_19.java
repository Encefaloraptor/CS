package com.example;

import lombok.*;

@Getter
@ToString
@Builder(builderMethodName = "interno")
class Usuario {

    // @NonNull
    private String email;
    private String nombre;

    // Sobrecargo el método builder para que reciba el parámetro nombre
    // El método devuelve un nuevo tipo UsuarioBuilder, formado por el método
    // interno() y el método nombre().
    // El tipo UsuarioBuilder es un tipo interno estático de Usuario, por lo que no se puede
    // acceder desde fuera de Usuario y debe ser creado por el método interno().
    // La convención para nombrar el tipo devuelto es el nombre de la clase original
    // seguido de Builder.
    // Realmente solo estamos sobreescribiendo el builder original con el nombre especificado en 
    // builderMethodName
    public static UsuarioBuilder builder(String n) {
        return interno().nombre(n);
    }
    public static boolean isInstanceUsuario(Object u){
        return u instanceof Usuario; 
    }
    public static boolean isInstanceUsuarioBuilder(Object u){
        return u instanceof UsuarioBuilder; 
    }

}

public class Ej17_19 {
    public static void main(String[] args) {
        // Paso el parámetro nombre al builder
        Usuario u = Usuario.builder("Ana")
                .email("ana@mail.gal")
                .build();

        // Cuando accedemos al builder, está retornando un objeto de tipo UsuarioBuilder, pero al tratarse de un 
        // tipo interno estático no podemos acceder desde fuera por eso da error
        Usuario u2 = Usuario.builder("Nadia"); 

        // Por tanto recurrimos al .build() que transforma el UsuarioBuilder en una instancia de la clase Usuario
        Usuario u2 = Usuario.builder("Nadia").build(); 

        System.out.println(u);        

        System.out.println(Usuario.isInstanceUsuario(u));
        System.out.println(Usuario.isInstanceUsuarioBuilder(u));

        System.out.println();

        System.out.println(Usuario.isInstanceUsuario(u2));
        System.out.println(Usuario.isInstanceUsuarioBuilder(u2));

    }
}
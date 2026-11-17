package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// La clase Usuario no crea los getters ni setters. 
// Tampoco el constructor con todos los argumentos ni 
// el constructor sin argumentos ni la sobrecarga del
// método toString()

// @AllArgsConstructor genera un constructor para 
// todos los argumentos no estáticos de la clase.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Usuario {
    private long id;
    private String nombre;
    private String apellidos;
}

public class Ej17_6 {
    public static void main(String[] args) {

        // constructor sin argumentos
        Usuario usuario = new Usuario();

        // setters
        usuario.setId(1);
        usuario.setNombre("Juan");
        usuario.setApellidos("Pérez López");

        // getters
        System.out.println(usuario.getId());
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getApellidos());

        // constructor con todos los argumentos
        Usuario usuario2 = new Usuario(2, "Eva", "Sanz");

        // toString sobreescrita por lombok:
        System.out.println("toString del 2º usuario:");
        System.out.println("\t" + usuario2);
    }
}

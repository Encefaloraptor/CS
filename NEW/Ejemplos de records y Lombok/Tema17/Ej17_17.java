package com.example;

import lombok.*;

@Getter
@Builder
@ToString

class Usuario {
    private String nombre;
    private int id;
    private String email;
}

class Ej17_17 {
    public static void main(String[] args) {

        Usuario u = Usuario.builder().nombre("Ana").id(1).email("ana@gmail.com").build();
        System.out.println(u);
    }
}

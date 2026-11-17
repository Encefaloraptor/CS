package com.example;

import lombok.*;

@ToString
@Getter
@Builder(toBuilder = true)

class Usuario {
  private String nombre;
  private int id;
}

public class Ej17_18 {
  public static void main(String[] args) {

    Usuario u = Usuario.builder().nombre("Ana").id(1).build();
    System.out.println(u);
    // método toBuilder para crear un nuevo objeto con los mismos valores que el
    // original, pero con la posibilidad de modificar alguno de ellos
    // para ello llamo al parámetro que quiero modificar y le asigno el nuevo valor
    // y por último llamo al método build para crear el nuevo objeto
    Usuario u2 = u.toBuilder().id(2).build();
    System.out.println(u2);
  }
}

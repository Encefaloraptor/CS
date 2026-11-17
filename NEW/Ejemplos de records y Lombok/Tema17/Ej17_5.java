package com.example;

public class Ej17_5 {
  record Empleado(String nombre, int id) {
  };

  public static void muestraObjeto(Object obj) {
    if (obj instanceof Empleado(String nombre, int id))
      System.out.println("id de  " + nombre + ": " + id);
    else
      System.out.println("Contenido: " + obj.toString());
  }

  public static void main(String args[]) {
    muestraObjeto("String normal");
    muestraObjeto(new Empleado("Samuel", 17));
  }
}

package com.example;

record Empleado(String nombre, int id) {

  static int idPte = -1; // campo estático

  public Empleado { // constructor canónico
    nombre = nombre.trim();
  }

  // Constructor no-canónico. No se le pasa valor
  // para el id, sino que lee el idPte al canónico.
  public Empleado(String nombre) {
    this(nombre, idPte);
  }
}

public class Ej17_3 {
  public static void main(String[] args) {
    Empleado[] listEmp = new Empleado[3];

    listEmp[0] = new Empleado("Miguel", 1047);
    listEmp[1] = new Empleado("Laura", 1048);

    // Constructor no-canónico (sin id)
    listEmp[2] = new Empleado("Sandra");

    for (Empleado e : listEmp) {
      System.out.println("ID de " + e.nombre() + ": " +
          e.id());
    }
  }
}

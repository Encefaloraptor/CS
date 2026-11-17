package com.example;

import lombok.Getter;

public class Ej17_16 {

  @Getter(lazy = true)
  private final double[] cached = expensive(); //inicializamos a variable llamando al método expensive
  final int N = 100000;

  private double[] expensive() {
    double[] result = new double[N];
    for (int i = 0; i < result.length; i++) {
      result[i] = Math.asin(i);
    }
    System.out.println("Calculado");
    return result;
  }

  public static void main(String[] args) {

    Ej17_16 app = new Ej17_16();
    System.out.println(app.getCached().length);
    System.out.println(app.getCached().length);
  }
}

// la segunda vez ya no se ejecutó el método y, por eso,
// no se mostró el texto “Calculado”.

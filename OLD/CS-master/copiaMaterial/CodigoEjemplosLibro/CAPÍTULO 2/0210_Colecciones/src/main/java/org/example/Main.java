package org.example;


import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // ARRAY
        System.out.println("----ARRAYS----------");
        int[] edades = new int[10];
        String[] meses = new String[12];
        String[] coches = {"Volvo", "BMW", "Ford", "Mazda"};
        for (int i = 0; i < coches.length; i++)
            System.out.println(coches[i]); //La primera posición es la cero
        System.out.println("--------------");
        for (String coche : coches)
            System.out.println(coche);

        //ARRAYLIST
        System.out.println("\n----ARRAYLIST---------");
        ArrayList<Integer> miLista = new ArrayList<>();
        miLista.add(100);
        miLista.add(50);
        miLista.add(75);
        System.out.println("ArrayList:" + miLista);
        System.out.println("Tamaño del arraylist: " + miLista.size());
        System.out.printf("El número 50 está en la posición %d\n", miLista.indexOf(50));
        Collections.sort(miLista);
        System.out.println("ArrayList ordenado:" + miLista);

        //CONJUNTOS
        System.out.println("\n----SET---------");
        Set<Jugador> equipo = new HashSet<>();
        equipo.add(new Jugador("Lamine Yamal", LocalDate.parse("2007-07-13")));
        equipo.add(new Jugador("Lamine Yamal", LocalDate.parse("2007-07-13")));
        equipo.add(new Jugador("Nico Williams", LocalDate.parse("2002-07-12")));
        System.out.println("HashSet:" + equipo);

        //MAPAS
        System.out.println("\n----MAP---------");
        Map<String, Integer> mapaPaises = new HashMap<>();
        mapaPaises.put("España", 47000000);
        if (mapaPaises.containsKey("Portugal"))
            mapaPaises.put("Portugal", mapaPaises.get("Portugal ") + 100000);
        else mapaPaises.put("Portugal", 0);
        for (String key : mapaPaises.keySet())
            System.out.println(key + " tiene " + mapaPaises.get(key) + " habitant.");
    }
}
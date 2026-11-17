package com.example;

record Empleado(String nombre, int id) {
    public Empleado {
        nombre = nombre.trim(); // elimina espacios
    }
}

class Ej17_2 {
    public static void main(String[] args) {
        Empleado[] listEmp = new Empleado[3];

        // nombres con espacios iniciales y finales
        listEmp[0] = new Empleado(" Miguel  ", 1047);
        listEmp[1] = new Empleado("Laura ", 1048);
        listEmp[2] = new Empleado("  Sandra", 1049);

        for (Empleado e : listEmp)
            System.out.println(e.nombre() + ": " + e.id());
    }
}

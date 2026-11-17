package com.example;
//Son inmutables
record Empleado(String nombre, int id) {
}

class Ej17_1 {
    public static void main(String[] args) {
        
        // array de registros:
        Empleado[] listEmp = new Empleado[4];

        // Los argumentos se asignan automáticamente
        // a los campos
        listEmp[0] = new Empleado("Miguel", 1047);
        listEmp[1] = new Empleado("Laura", 1048);
        listEmp[2] = new Empleado("Sandra", 1049);
        listEmp[3] = new Empleado("Antón", 1050);

        // Usa los métodos ‘accesores’ para leer los nombres y
        // los identificadores
        for (Empleado e : listEmp)
            System.out.println(e.nombre() + ": " + e.id());
    }
}

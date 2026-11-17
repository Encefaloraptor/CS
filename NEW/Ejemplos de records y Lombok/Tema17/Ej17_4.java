package com.example;

record Empleado(String nombre, int id) {
    public Empleado {
        nombre = nombre.trim();
        int i = nombre.indexOf(','); // busca coma
        int j = nombre.lastIndexOf(',');
        if (i != j)
            throw new IllegalArgumentException("Varias comas");
        if (i < 1 | nombre.length() == i + 1)
            throw new IllegalArgumentException("formato erróneo");
    }

    String apellido() { // método que devuelve el apellido
        return nombre.substring(0, nombre.trim().indexOf(','));
    }
}

class Ej17_4 {
    public static void main(String[] args) {
        Empleado emp = new Empleado("López, Brais", 76);
        System.out.println("Empleado: " + emp.nombre());
        System.out.println("Apellido: " + emp.apellido());
    }
}

package com.Alvarocampos.Proyecto07.Ejercicio04;

public class Main {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        // Añade valores aleatorios
        cola.add(10);
        cola.add(60);
        cola.add(12);
        System.out.println("Cola despues de añadir elementos:  " + cola);

        // Eliminando elementos
        System.out.println("Elemento eliminado: " + cola.remove());
        System.out.println("Cola despues de eliminar: " + cola);

        // Consultando el primer elemento
        System.out.println("Primer elemento (peek): " + cola.peek());

        // Verificando si está vacía
        System.out.println("¿La cola está vacía? " + cola.isEmpty());
    }
}
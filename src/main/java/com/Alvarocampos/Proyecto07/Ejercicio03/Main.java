package com.Alvarocampos.Proyecto07.Ejercicio03;

class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        // Añade valores aleatorios
        pila.push(10);
        pila.push(60);
        pila.push(12);
        System.out.println("Pila despues de añadir elementos: " + pila);

        // Borra un elemento
        System.out.println("Elemento eliminado: " + pila.pop());
        System.out.println("Pila despues de eliminar un elemento: " + pila);

        // Consulta el elemento superior
        System.out.println("Elemento en la cima: " + pila.top());
    }
}

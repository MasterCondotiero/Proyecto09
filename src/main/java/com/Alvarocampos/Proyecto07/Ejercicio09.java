package com.Alvarocampos.Proyecto07;

import java.util.*;

public class Ejercicio09 {
    private static final int MAX_MEJORES = 5;
    private static final List<Map.Entry<String, Integer>> mejoresPuntuaciones = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> diccionario = new HashMap<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEnteroConValidacion(scanner, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    anadirPalabra(scanner, diccionario);
                    break;
                case 2:
                    modificarPalabra(scanner, diccionario);
                    break;
                case 3:
                    eliminarPalabra(scanner, diccionario);
                    break;
                case 4:
                    consultarPalabra(scanner, diccionario);
                    break;
                case 5:
                    mostrarDiccionario(diccionario);
                    break;
                case 6:
                    jugar(scanner, diccionario);
                    break;
                case 7:
                    mostrarMejoresPuntuaciones();
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("***********************");
        System.out.println("* JUEGO DICCIONARIO  *");
        System.out.println("***********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("6. Jugar");
        System.out.println("7. Mejores puntuaciones");
        System.out.println("-----------------------");
        System.out.println("0. Salir");
    }

    private static int leerEnteroConValidacion(Scanner scanner, String mensaje) {
        int numero = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número.");
            }
        }
        return numero;
    }

    private static void anadirPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Error: la palabra ya existe en el diccionario.");
        } else {
            System.out.print("Introduce su definición: ");
            String definicion = scanner.nextLine().trim();
            diccionario.put(palabra, definicion);
            System.out.println("Palabra añadida correctamente.");
        }
    }

    private static void modificarPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra a modificar: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Definición actual: " + diccionario.get(palabra));
            System.out.print("Introduce la nueva definición: ");
            String nuevaDefinicion = scanner.nextLine().trim();
            diccionario.put(palabra, nuevaDefinicion);
            System.out.println("Palabra modificada correctamente.");
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

    private static void eliminarPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra a eliminar: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            diccionario.remove(palabra);
            System.out.println("Palabra eliminada correctamente.");
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

    private static void consultarPalabra(Scanner scanner, Map<String, String> diccionario) {
        System.out.print("Introduce la palabra a consultar: ");
        String palabra = scanner.nextLine().trim().toLowerCase();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Definición: " + diccionario.get(palabra));
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

    private static void mostrarDiccionario(Map<String, String> diccionario) {
        if (diccionario.isEmpty()) {
            System.out.println("El diccionario está vacío.");
        } else {
            System.out.println("=== CONTENIDO DEL DICCIONARIO ===");
            for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
                System.out.println("- " + entrada.getKey() + ": " + entrada.getValue());
            }
        }
    }

    private static void jugar(Scanner scanner, Map<String, String> diccionario) {
        if (diccionario.isEmpty()) {
            System.out.println("No hay palabras en el diccionario. Agrega algunas primero.");
            return;
        }

        List<Map.Entry<String, String>> listaPalabras = new ArrayList<>(diccionario.entrySet());
        Collections.shuffle(listaPalabras);

        int puntuacion = 0;
        for (Map.Entry<String, String> entrada : listaPalabras) {
            System.out.println("Definición: " + entrada.getValue());
            System.out.print("¿Cuál es la palabra? ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals(entrada.getKey())) {
                puntuacion++;
                System.out.println("¡Correcto! Puntuación actual: " + puntuacion);
            } else {
                System.out.println("¡Incorrecto! La palabra era: " + entrada.getKey());
                break;
            }
        }

        System.out.println("Fin del juego. Puntuación final: " + puntuacion);
        comprobarMejorPuntuacion(scanner, puntuacion);
    }

    private static void comprobarMejorPuntuacion(Scanner scanner, int puntuacion) {
        if (mejoresPuntuaciones.size() < MAX_MEJORES || //puntuacion > mejoresPuntuaciones.get(mejoresPuntuaciones.size() - 1).getValue()) {
                puntuacion > mejoresPuntuaciones.getLast().getValue()) {

            System.out.print("¡Nueva mejor puntuación! Introduce tu nombre: ");
            String nombre = scanner.nextLine().trim();

            mejoresPuntuaciones.add(new AbstractMap.SimpleEntry<>(nombre, puntuacion));
            mejoresPuntuaciones.sort((a, b) -> b.getValue() - a.getValue());

            if (mejoresPuntuaciones.size() > MAX_MEJORES) {
                mejoresPuntuaciones.removeLast();
                //mejoresPuntuaciones.remove(mejoresPuntuaciones.size() - 1);
            }
        }
    }

    private static void mostrarMejoresPuntuaciones() {
        if (mejoresPuntuaciones.isEmpty()) {
            System.out.println("No hay puntuaciones registradas.");
        } else {
            System.out.println("=== MEJORES PUNTUACIONES ===");
            for (int i = 0; i < mejoresPuntuaciones.size(); i++) {
                Map.Entry<String, Integer> entrada = mejoresPuntuaciones.get(i);
                System.out.println((i + 1) + ". " + entrada.getKey() + ": " + entrada.getValue());
            }
        }
    }
}

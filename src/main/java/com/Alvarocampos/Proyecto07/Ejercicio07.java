package com.Alvarocampos.Proyecto07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio07 {
    public static void main(String[] args) {
        // Crear el mapa con las tasas de cambio
        Map<String, Double> tasasCambio = new HashMap<String, Double>();
        Scanner scanner = new Scanner(System.in);
        double euros;
        boolean valido = false;

        while (!valido){
            tasasCambio.put("USD", 1.08);       // Dólar USA
            tasasCambio.put("GBP", 0.85);       // Libra esterlina
            tasasCambio.put("INR", 89.50);      // Rupia India
            tasasCambio.put("AUD", 1.64);       // Dólar Australiano
            tasasCambio.put("CAD", 1.47);       // Dólar Canadiense
            tasasCambio.put("ARS", 919.45);     // Peso Argentino
            tasasCambio.put("BOB", 7.44);       // Boliviano Boliviano
            tasasCambio.put("CLP", 987.20);     // Peso Chileno
            tasasCambio.put("VEZ", 4050.00);    // Peso Colombiano
            tasasCambio.put("CRC", 571.18);     // Colón Costarricense
            tasasCambio.put("CUP", 26.50);      // Peso Cubano
            tasasCambio.put("DOP", 63.80);      // Peso Dominicano
            tasasCambio.put("MXN", 18.20);      // Peso Mexicano

            System.out.println("Introduce la cantidad en euros: ");
            try {
                euros = Double.parseDouble(scanner.nextLine());
                if (euros<0){
                    System.out.println("Valor negativo no valido.");
                    valido = true;
                }
                System.out.println("Conversión de " + euros + " EUR:");
                for (Map.Entry<String, Double> entrada : tasasCambio.entrySet()) {
                    String moneda = entrada.getKey();
                    Double valor = entrada.getValue();
                    double convertido = euros * valor;
                    System.out.printf("- %s: %.2f\n", moneda, convertido);
                }
            } catch (InputMismatchException ime){
                //Thrown by a Scanner to indicate that the token retrieved does not match the pattern for the expected type,
                // or that the token is out of range for the expected type.
                System.out.println("EL valor que se ha proporcionado no es numerico, finalizando el programa");
                valido = true;
            }
        }
        scanner.close();
    }
}

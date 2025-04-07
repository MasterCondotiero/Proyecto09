package com.Alvarocampos.Proyecto07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        // Crear el mapa con las tasas de cambio
        Map<String, Double> tasasCambio = new HashMap<String, Double>();

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la cantidad en euros: ");
        double euros = scanner.nextDouble();

        System.out.println("Conversión de " + euros + " EUR:");

        for (Map.Entry<String, Double> entrada : tasasCambio.entrySet()) {
            String moneda = entrada.getKey();
            Double valor = entrada.getValue();
            double convertido = euros * valor;
            System.out.printf("- %s: %.2f\n", moneda, convertido);
        }
        scanner.close();
    }
}

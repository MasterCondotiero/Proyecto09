package com.Alvarocampos.Proyecto07;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio06 {
    //Lo mejor es una estructura usando HashMap <String, String>, tiene busqueda rapida
    // y puedes usar una de las dos palabras como "key" aunque eso te obliga a buscar por ese idioma
    //No permite duplicados en las claves
    public static void main(String[] args) {
        Map<String, String> diccionario = new HashMap<>();

        diccionario.put("bed", "llit");
        diccionario.put("chair", "cadira");

        System.out.println(diccionario.get("chair")); // cadira

        String traduccion = diccionario.get("green");
        if (traduccion == null) {
            System.out.println("La palabra no existe.");
        }
    }
}

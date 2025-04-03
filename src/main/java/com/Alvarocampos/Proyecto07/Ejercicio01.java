package com.Alvarocampos.Proyecto07;

import java.util.ArrayList;
import java.util.Random;

public class Ejercicio01 {
    public static Random random = new Random();
    public static void main(String[] args){
        ArrayList<Integer> arrayOrdenado = new ArrayList<>();
        final int TAMANYO = 10;
        int[] array = new int[TAMANYO];
        randoEnteros(array);
        arrayOrdenaditoInt(array);
        muestraArrayList(arrayOrdenado);
    }
    public static void randoEnteros(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(0,51);
        }
    }
    public static ArrayList<Integer> arrayOrdenaditoInt(int[] array){
        ArrayList<Integer> arrayOrdenado = new ArrayList<>();
        for (int i = 0; i<array.length; i++){
            if (array[i] % 2 == 0){
                arrayOrdenado.add(array[i]);
            }
        }
        for (int i = 0; i<array.length; i++){
            if (array[i] % 2 !=0){
                arrayOrdenado.add(array[i]);
            }
        }
        return arrayOrdenado;
    }
    public static void muestraArrayList(ArrayList<Integer> arrayOrdenadito){
        for (int i = 0; i < arrayOrdenadito.size(); i++){
            System.out.println(arrayOrdenadito.toString());
        }
    }
}

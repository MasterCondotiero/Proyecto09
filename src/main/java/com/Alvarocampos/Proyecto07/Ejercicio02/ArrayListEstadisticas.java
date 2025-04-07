package com.Alvarocampos.Proyecto07.Ejercicio02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadisticas {
    @Override
    public double minimo() {
        double min = Double.MAX_VALUE;
        for (double valor : this){
            if (valor<min){
                min=valor;
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = Double.MAX_VALUE;
        for (double valor : this){
            if (valor>max){
                max=valor;
            }
        }
        return max;
    }

    @Override
    public double sumatorio() {
        double suma = 0;
        for (double num : this) {
            suma += num;
        }
        return suma;
    }

    @Override
    public double media() {
        if (this.isEmpty()) return 0;
        return sumatorio() / this.size();
    }

    @Override
    public double moda() {
        if (this.isEmpty()) return Double.NaN;

        Map<Double, Integer> frecuencia = new HashMap<>();
        for (double num : this) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }

        double moda = this.get(0);
        int maxFrecuencia = 0;
        for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }

        return moda;
    }
}

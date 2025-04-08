package com.Alvarocampos.Proyecto07.Ejercicio05;

import java.util.List;

public class GestionPaciente {
    public static int[] majorMenor(List<Paciente> pacientes) {
        int posMenor = 0;
        int posMayor = 0;
        int edadMenor = pacientes.getFirst().calcularEdad();
        int edadMayor = pacientes.getFirst().calcularEdad();

        for (int i = 1; i < pacientes.size(); i++) {
            int edad = pacientes.get(i).calcularEdad();
            if (edad < edadMenor) {
                edadMenor = edad;
                posMenor = i;
            }
            if (edad > edadMayor) {
                edadMayor = edad;
                posMayor = i;
            }
        }
        return new int[]{posMenor, posMayor};
    }

    public static int[] pacientsPerSexe(List<Paciente> pacientes) {
        int hombres = 0, mujeres = 0;
        for (Paciente p : pacientes) {
            if (p.getSexo() == Sexo.M) hombres++;
            else if (p.getSexo() == Sexo.F) mujeres++;
        }
        return new int[]{hombres, mujeres};
    }

}
package com.Alvarocampos.Proyecto07.Ejercicio05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Godofreda", LocalDate.of(1980,02,03) , Sexo.F, 57, 1.63));
        pacientes.add(new Paciente("Eustaquio", LocalDate.of(1998,12,17), Sexo.M, 60.5, 1.74));
        pacientes.add(new Paciente("Gertrudis", LocalDate.of(2007,02,03), Sexo.F, 50.8, 1.62));
        pacientes.add(new Paciente("Alex", LocalDate.of(1870,8,25), null, 72.5, 1.78));
        pacientes.add(new Paciente("Segismundo", LocalDate.of(1980,7,6), Sexo.M, 85.2, 1.80));
        pacientes.add(new Paciente("Pablo", LocalDate.of(1980,7,6), Sexo.M, 100.8, 1.80));

        int[] edades = GestionPaciente.majorMenor(pacientes);
        int[] sexos = GestionPaciente.pacientsPerSexe(pacientes);

        System.out.println("PACIENTE MAYOR " + pacientes.get(edades[1]));
        System.out.println("PACIENTE MENOR " + pacientes.get(edades[0]));

        System.out.println("Cantidad de pacientes por sexos:");
        System.out.println("Hombres: " + sexos[0]);
        System.out.println("Mujeres: " + sexos[1]);

        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("Paciente número " + (i + 1) + ": " + pacientes.get(i).interpretarIMC() + ".");
        }
    }
}

package com.Alvarocampos.Proyecto07.Ejercicio05;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Paciente {
    private final int identificador;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private Sexo sexo;
    private double altura;                              // en metros
    private double peso;                               // en Kg
    private static int contadorId = 1;

    public Paciente(String nombre, LocalDate fechaNacimiento, Sexo sexo, double altura, double peso) {
        this.identificador = generadorIdentificador();
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public Paciente(String nombre, LocalDate fechaNacimiento, double altura, double peso) {
        this.identificador = generadorIdentificador();
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = Sexo.M;                         // Por defecto masculino
        this.altura = altura;
        this.peso = peso;
    }

    private static int generadorIdentificador() {
        return contadorId++;
    }

    public int calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String interpretarIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) return "Peso insuficiente";
        else if (imc < 25) return "Peso normal";
        else if (imc < 27) return "Sobrepeso grado I";
        else if (imc < 30) return "Sobrepeso grado II";
        else return "Sobrepeso grado III";
    }

    public Sexo getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Paciente{" +
                "ID=" + identificador +
                ", Nombre='" + nombre + '\'' +
                ", Fecha de Nacimiento=" + fechaNacimiento.format(formatter) +
                ", Sexo=" + sexo +
                ", Altura=" + altura + " m" +
                ", Peso=" + peso + " kg" +
                ", Edad=" + calcularEdad() + " años" +
                '}';
    }
}
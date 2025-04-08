package com.Alvarocampos.Proyecto07.Ejercicio10;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

class Empleado {
    private final String dni;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private double sueldo;
    private List<Hijo> hijos = new ArrayList<>();

    public Empleado(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public List<Hijo> getHijos() {
        return hijos;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s) - Sueldo: %.2f, Edad: %d, Hijos: %s",
                nombre, apellidos, dni, sueldo,
                Period.between(fechaNacimiento, LocalDate.now()).getYears(),
                hijos.toString());
    }
}

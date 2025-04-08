package com.Alvarocampos.Proyecto07.Ejercicio10;

import java.time.LocalDate;
import java.time.Period;

class Hijo {
    private final String nombre;
    private final LocalDate fechaNacimiento;

    public Hijo(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre + " ("
                + Period.between(fechaNacimiento, LocalDate.now()).getYears()
                + " años)";
    }
}

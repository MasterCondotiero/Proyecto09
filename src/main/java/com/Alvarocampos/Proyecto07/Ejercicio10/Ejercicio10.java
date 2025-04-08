package com.Alvarocampos.Proyecto07.Ejercicio10;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Ejercicio10 {
    static Scanner scanner = new Scanner(System.in);
    static RandomFecha rd = new RandomFecha(LocalDate.of(1900, 1, 1), LocalDate.of(2010, 1, 1));
    static Map<String, Empleado> empleados = new HashMap<>();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> nuevoEmpleado();
                case 2 -> nuevoHijo();
                case 3 -> modificarSueldo();
                case 4 -> borrarEmpleado();
                case 5 -> borrarHijo();
                case 6 -> menuConsultas();
                case 7 -> generarEmpleadosAleatorios(5); // EMpleados aleatorios :v
                case 0 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    static void mostrarMenu() {
        System.out.println("*********************");
        System.out.println("* GESTIÓN EMPLEADOS *");
        System.out.println("*********************");
        System.out.println("1. Nuevo empleado");
        System.out.println("2. Nuevo hijo");
        System.out.println("3. Modificar sueldo");
        System.out.println("4. Borrar empleado");
        System.out.println("5. Borrar hijo");
        System.out.println("6. Consultas");
        System.out.println("7. Generar empleados aleatorios");
        System.out.println("0. Salir");
    }

    static void nuevoEmpleado() {
        System.out.print("DNI: ");
        String dni = scanner.nextLine().trim();

        if (empleados.containsKey(dni)) {
            System.out.println("Ya existe un empleado con ese DNI.");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine().trim();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine().trim());
        double sueldo = leerDouble("Sueldo: ");

        empleados.put(dni, new Empleado(dni, nombre, apellidos, fechaNacimiento, sueldo));
        System.out.println("Empleado añadido correctamente.");
    }

    static void nuevoHijo() {
        System.out.print("DNI del empleado: ");
        String dni = scanner.nextLine().trim();
        Empleado emp = empleados.get(dni);

        if (emp == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        System.out.print("Nombre del hijo: ");
        String nombre = scanner.nextLine().trim();
        System.out.println("Fecha de nacimiento (YYYY-MM-DD) del hijo: ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine().trim());
        emp.getHijos().add(new Hijo(nombre, fechaNacimiento));
        System.out.println("Hijo añadido correctamente.");
    }

    static void modificarSueldo() {
        System.out.print("DNI del empleado: ");
        String dni = scanner.nextLine().trim();
        Empleado emp = empleados.get(dni);

        if (emp == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        double nuevoSueldo = leerDouble("Nuevo sueldo: ");
        emp.setSueldo(nuevoSueldo);
        System.out.println("Sueldo actualizado.");
    }

    static void borrarEmpleado() {
        System.out.print("DNI del empleado a borrar: ");
        String dni = scanner.nextLine().trim();

        if (empleados.remove(dni) != null) {
            System.out.println("Empleado borrado.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    static void borrarHijo() {
        System.out.print("DNI del empleado: ");
        String dni = scanner.nextLine().trim();
        Empleado emp = empleados.get(dni);

        if (emp == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        System.out.print("Nombre del hijo a borrar: ");
        String nombre = scanner.nextLine().trim();

        boolean eliminado = emp.getHijos().removeIf(h -> h.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            System.out.println("Hijo borrado.");
        } else {
            System.out.println("Hijo no encontrado.");
        }
    }

    static void menuConsultas() {
        int opcion;
        do {
            System.out.println("***********************");
            System.out.println("* CONSULTAS EMPLEADOS *");
            System.out.println("***********************");
            System.out.println("1. Buscar por NIF");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Buscar por rango de edad");
            System.out.println("4. Buscar por rango de sueldo");
            System.out.println("5. Buscar por hijos menores de edad");
            System.out.println("0. Volver al menú principal");

            opcion = leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1 -> buscarPorNif();
                case 2 -> buscarPorNombre();
                case 3 -> buscarPorEdad();
                case 4 -> buscarPorSueldo();
                case 5 -> buscarPorHijosMenores();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    static void buscarPorNif() {
        System.out.print("DNI: ");
        String dni = scanner.nextLine().trim();
        Empleado emp = empleados.get(dni);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("No encontrado.");
        }
    }

    static void buscarPorNombre() {
        System.out.print("Nombre o parte: ");
        String nombre = scanner.nextLine().trim().toLowerCase();
        empleados.values().stream()
                .filter(e -> e.getNombre().toLowerCase().contains(nombre))
                .forEach(System.out::println);
    }

    static void buscarPorEdad() {
        int edadMin = leerEntero("Edad mínima: ");
        int edadMax = leerEntero("Edad máxima: ");
        empleados.values().stream()
                .filter(e -> {
                    int edad = Period.between(e.getFechaNacimiento(), LocalDate.now()).getYears();
                    return edad >= edadMin && edad <= edadMax;
                })
                .forEach(System.out::println);
    }

    static void buscarPorSueldo() {
        double sueldoMin = leerDouble("Sueldo mínimo: ");
        double sueldoMax = leerDouble("Sueldo máximo: ");
        empleados.values().stream()
                .filter(e -> e.getSueldo() >= sueldoMin && e.getSueldo() <= sueldoMax)
                .forEach(System.out::println);
    }

    static void buscarPorHijosMenores() {
        /* empleados.values().stream()
                .filter(e -> e.getHijos().stream().anyMatch(h -> h.getEdad() < 18))
                .forEach(System.out::println);

        int edadMin = leerEntero("Edad mínima: "); */

        /* empleados.values().stream()
                .filter(e -> {
                    int edad = Period.between(e.getFechaNacimiento(), LocalDate.now()).getYears();
                    return edad >= edadMin;
                })
                .forEach(System.out::println); */
    }

    static void generarEmpleadosAleatorios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            String dni = "DNI" + (1000 + i);
            Empleado e = new Empleado(
                    dni,
                    "Nombre" + i,
                    "Apellido" + i,
                    LocalDate.of(1980 + i, 1, 1),
                    1000 + i * 500
            );
            if (i % 2 == 0) {
                e.getHijos().add(new Hijo("Hijo" + i, rd.nextDate()));
            }
            empleados.put(dni, e);
        }
        System.out.println("Empleados aleatorios generados.");
    }

    static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }
}


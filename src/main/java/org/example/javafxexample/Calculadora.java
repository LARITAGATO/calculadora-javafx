package org.example.javafxexample;

import java.util.ArrayList;

/**
 * Logica de la calculadora. No lee datos ni imprime el menu (eso es del Main).
 */
public class Calculadora {

    // Atributo static: pertenece a la clase, lo comparten todos los objetos.
    private static int totalOperaciones = 0;

    // Colecciones: operaciones disponibles e historial de resultados.
    private ArrayList<Operacion> operaciones;
    private ArrayList<String> historial;

    public Calculadora() {
        operaciones = new ArrayList<Operacion>();
        historial = new ArrayList<String>();
        // Polimorfismo de inclusion: la lista es de Operacion,
        // pero cada elemento es de una clase distinta.
        operaciones.add(new Suma());
        operaciones.add(new Resta());
        operaciones.add(new Multiplicacion());
        operaciones.add(new Division());
    }

    // Polimorfismo parametrico: mismo nombre "calcular", distintos parametros.

    // Version 1: recibe la operacion directamente.
    public double calcular(Operacion op, double a, double b) {
        double resultado = op.calcular(a, b);   // no sabemos que clase es: inclusion
        historial.add(a + " " + op.getSimbolo() + " " + b + " = " + resultado);
        totalOperaciones++;
        return resultado;
    }

    // Version 2: recibe la posicion elegida en el menu (1 a 4).
    public double calcular(int opcion, double a, double b) {
        if (opcion < 1 || opcion > operaciones.size()) {
            throw new IllegalArgumentException("Opcion de operacion invalida.");
        }
        return calcular(operaciones.get(opcion - 1), a, b);
    }

    public int cantidadOperaciones() {
        return operaciones.size();
    }

    public Operacion getOperacion(int opcion) {
        return operaciones.get(opcion - 1);
    }

    public ArrayList<String> getHistorial() {
        return historial;
    }

    public static int getTotalOperaciones() {
        return totalOperaciones;
    }
}

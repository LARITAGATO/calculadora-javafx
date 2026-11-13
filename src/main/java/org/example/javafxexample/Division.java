package org.example.javafxexample;

public class Division implements Operacion {
    @Override
    public String getSimbolo() {
        return "/";
    }

    @Override
    public double calcular(double a, double b) {
        // Con double Java no lanza error al dividir entre 0 (da Infinity),
        // por eso lo lanzamos nosotros.
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }
}

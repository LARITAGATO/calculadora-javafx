package org.example.javafxexample;

public class Suma implements Operacion {
    @Override
    public String getSimbolo() {
        return "+";
    }

    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}

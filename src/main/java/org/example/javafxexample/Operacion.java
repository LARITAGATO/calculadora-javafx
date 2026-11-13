package org.example.javafxexample;

/**
 * Contrato (interfaz): todo lo que sea una operacion debe saber calcular.
 * La Calculadora solo conoce este contrato, no las clases concretas.
 */
public interface Operacion {
    String getSimbolo();                    // por ejemplo "+"
    double calcular(double a, double b);    // hace la cuenta
}

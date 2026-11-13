package org.example.javafxexample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// Controlador: conecta la vista (calculadora-view.fxml) con la logica de la calculadora.
// Solo tiene la LOGICA de los botones (los colores estan en el FXML).
public class CalculadoraController {

    // ======================= ELEMENTOS DE LA VISTA (vienen del FXML por su fx:id) =======================
    @FXML private TextField pantalla;   // la pantalla donde se ven los numeros

    // ======================= LOGICA DE LA CALCULADORA =======================
    // Objeto con la logica: usa las clases Suma, Resta, Multiplicacion y Division
    private final Calculadora calculadora = new Calculadora();

    private double primero;               // el primer numero que escribio el usuario
    private int opcion = 0;               // operacion elegida: 1 suma, 2 resta, 3 multiplicacion, 4 division
    private boolean nuevoNumero = true;   // true = el proximo digito empieza un numero nuevo

    // Se ejecuta al presionar un numero (0-9) o el punto
    @FXML protected void onNumero(ActionEvent evento) {
        Button boton = (Button) evento.getSource();   // el boton que se presiono
        if (nuevoNumero) {
            pantalla.setText("");                     // limpia la pantalla para empezar otro numero
            nuevoNumero = false;
        }
        pantalla.appendText(boton.getText());         // agrega el digito al final
    }

    // Un metodo por cada operacion; todos guardan el primer numero y la operacion
    @FXML protected void onSumar()       { guardarOperacion(1); }
    @FXML protected void onRestar()      { guardarOperacion(2); }
    @FXML protected void onMultiplicar() { guardarOperacion(3); }
    @FXML protected void onDividir()     { guardarOperacion(4); }

    private void guardarOperacion(int op) {
        try {
            primero = Double.parseDouble(pantalla.getText());  // texto -> numero
            opcion = op;
            nuevoNumero = true;                                // el siguiente numero es el segundo
        } catch (NumberFormatException e) {
            pantalla.setText("Error");                         // la pantalla estaba vacia o invalida
            nuevoNumero = true;
        }
    }

    // Boton "=": hace el calculo con el primer numero, la operacion y el segundo numero
    @FXML protected void onIgual() {
        if (opcion == 0) {
            return;                                            // no se ha elegido operacion
        }
        try {
            double segundo = Double.parseDouble(pantalla.getText());
            double resultado = calculadora.calcular(opcion, primero, segundo);
            if (resultado == Math.floor(resultado)) {
                pantalla.setText(String.valueOf((long) resultado));  // entero: muestra 42 y no 42.0
            } else {
                pantalla.setText(String.valueOf(resultado));
            }
        } catch (NumberFormatException e) {
            pantalla.setText("Error");
        } catch (ArithmeticException e) {
            pantalla.setText("No / entre 0");                  // viene de la clase Division
        }
        opcion = 0;
        nuevoNumero = true;
    }

    // Boton "C": deja la calculadora como al inicio
    @FXML protected void onLimpiar() {
        pantalla.setText("");
        primero = 0;
        opcion = 0;
        nuevoNumero = true;
    }
}

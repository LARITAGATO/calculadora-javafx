# Calculadora JavaFX

Reto de Programación Orientada a Objetos (POO): calculadora con las 4 operaciones básicas
(suma, resta, multiplicación y división) con interfaz gráfica en **JavaFX**.

**Autor:** Juan David Lara — Ingeniería Informática, Universidad de La Sabana.

## Cómo está organizado

| Archivo | Qué hace |
|---|---|
| `Operacion.java` | Interfaz que define el contrato de una operación |
| `Suma`, `Resta`, `Multiplicacion`, `Division` | Una clase por operación (implementan `Operacion`, polimorfismo) |
| `Calculadora.java` | Elige la operación según la opción y la ejecuta |
| `CalculadoraController.java` | Controlador JavaFX: conecta los botones con la lógica |
| `calculadora-view.fxml` | Vista (diseño con Scene Builder, estilos Bootstrap en línea) |
| `HelloApplication.java` | Clase principal que abre la ventana |

La división entre cero se controla y muestra el mensaje `No / entre 0`.

## Cómo ejecutarla

Requisitos: **JDK 21** y **Maven**.

```bash
mvn clean javafx:run
```

También se puede abrir en IntelliJ IDEA y ejecutar `HelloApplication`.

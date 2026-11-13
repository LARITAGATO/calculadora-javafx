module org.example.javafxexample {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.javafxexample to javafx.fxml;
    exports org.example.javafxexample;
}

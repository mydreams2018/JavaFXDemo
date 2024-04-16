module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    opens com.example.javafxdemo to javafx.fxml;
    exports com.example.javafxdemo;
}
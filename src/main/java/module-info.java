module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    opens com.example.javafxdemo to javafx.fxml;
    opens com.example.javafxdemo.table to javafx.fxml;
    exports com.example.javafxdemo;
    exports com.example.javafxdemo.table;
    exports com.example.javafxdemo.move;
}
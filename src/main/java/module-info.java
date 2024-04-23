module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.graphics;

    opens com.example.javafxdemo to javafx.fxml;
    opens com.example.javafxdemo.table to javafx.fxml;
    opens com.example.javafxdemo.chart to javafx.fxml;
    exports com.example.javafxdemo;
    exports com.example.javafxdemo.table;
    exports com.example.javafxdemo.move;
    exports com.example.javafxdemo.chart;
    exports com.example.javafxdemo.html;
    exports com.example.javafxdemo.color;
    exports com.example.javafxdemo.effect;
    exports com.example.javafxdemo.games;
    exports com.example.javafxdemo.games.three;
}
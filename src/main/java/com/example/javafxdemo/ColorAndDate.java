package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class ColorAndDate extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setMinWidth(120);

        DatePicker datePicker = new DatePicker();
        datePicker.setMinWidth(120);
        datePicker.setEditable(false);
        datePicker.setOnAction(e -> {
            LocalDate date = datePicker.getValue();
            System.out.println("Selected date: " + date);
        });
        root.getChildren().addAll(colorPicker, datePicker);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

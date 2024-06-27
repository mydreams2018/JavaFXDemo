package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextAreaDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();

        TextArea textArea = new TextArea();
        textArea.setWrapText(false);
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            String[] split = newValue.split("\n", 5);
            System.out.println(Arrays.toString(split));
            System.out.println(split.length);
        });
        group.getChildren().add(textArea);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TextArea Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class ArcDemo  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Arc arc = new Arc();
        arc.setCenterX(50.0f);
        arc.setCenterY(50.0f);
        arc.setRadiusX(25.0f);
        arc.setRadiusY(25.0f);
        arc.setStartAngle(90);
        arc.setLength(270);
        arc.setType(ArcType.ROUND);
        root.getChildren().add(arc);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);
        primaryStage.setTitle("UserUiView");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

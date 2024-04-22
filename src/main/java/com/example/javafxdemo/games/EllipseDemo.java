package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class EllipseDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();


        //width:100.0 height:50.0
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(50.0f);
        ellipse.setCenterY(25.0f);
        ellipse.setRadiusX(50.0f);
        ellipse.setRadiusY(25.0f);

        System.out.println(ellipse.getLayoutBounds());
        System.out.println(ellipse.getBoundsInLocal());
        System.out.println(ellipse.getBoundsInParent());

        root.getChildren().add(ellipse);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 椭圆形");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

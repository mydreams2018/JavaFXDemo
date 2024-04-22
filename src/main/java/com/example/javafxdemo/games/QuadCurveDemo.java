package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class QuadCurveDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        //二次贝塞尔参数曲线段
        QuadCurve quad = new QuadCurve();
        quad.setStartX(0.0f);
        quad.setStartY(100.0f);
        quad.setEndX(100.0f);
        quad.setEndY(100.0f);
        quad.setControlX(0);
        quad.setControlY(0);

        quad.setStroke(Color.RED);
        quad.setStrokeWidth(2);

        root.getChildren().add(quad);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 二次贝塞尔参数曲线段");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        System.out.println(quad.getLayoutBounds());
        System.out.println(quad.getBoundsInLocal());
        System.out.println(quad.getBoundsInParent());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

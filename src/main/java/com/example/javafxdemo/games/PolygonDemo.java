package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class PolygonDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Polygon polygon = new Polygon();
        //自动闭合 最后一个点 和 第一个点
        polygon.getPoints().addAll(new Double[]{
                0.0, 0.0,
                200.0, 100.0,
                100.0, 200.0});
        polygon.setFill(Color.RED);
        polygon.setStrokeWidth(2);
        polygon.setStroke(Color.GREEN);

        root.getChildren().add(polygon);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 多边形");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

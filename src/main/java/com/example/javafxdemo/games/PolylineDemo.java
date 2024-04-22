package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class PolylineDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Polyline polyline = new Polyline();
        //200 * 200
        polyline.getPoints().addAll(new Double[]{
                0.0, 0.0,
                200.0, 100.0,
                100.0, 200.0,
                0.0, 0.0});
        polyline.setLayoutX(10);
        polyline.setLayoutY(10);
        polyline.setStroke(Color.RED);
        //填充的色彩
        polyline.setFill(Color.BLUE);
        polyline.setStrokeWidth(5);
        //定义strokeWidth应用于形状边界的方向 (内部居中或外部 )
        polyline.setStrokeType(StrokeType.INSIDE);
        polyline.setStrokeLineCap(StrokeLineCap.ROUND);

        System.out.println(polyline.getLayoutBounds());
        System.out.println(polyline.getBoundsInLocal());
        System.out.println(polyline.getBoundsInParent());

        root.getChildren().add(polyline);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 多条线");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class RectangleDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setPadding(new Insets(10,10,10,10));

        Rectangle r = new Rectangle();
        r.setWidth(200);
        r.setHeight(100);
        //定义矩形四个角处圆弧的水平直径 当且仅当弧宽和弧高属性都大于 0.0 时 矩形才具有圆角
        r.setArcWidth(20);
        r.setArcHeight(20);
        r.setFill(Color.GREEN);
        //边框
        r.setStroke(Color.RED);
        r.setStrokeType(StrokeType.CENTERED);
        r.setStrokeWidth(3);
        //角度 StrokeLineCap.ROUND 圆角
        r.setStrokeLineCap(StrokeLineCap.ROUND);

        root.getChildren().add(r);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 矩形");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

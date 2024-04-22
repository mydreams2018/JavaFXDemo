package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.stage.Stage;

public class LineDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Line line = new Line();
        line.setStartX(0.0f);
        line.setStartY(0.0f);
        line.setEndX(100.0f);
        line.setEndY(100.0f);
        //线条色彩
        line.setStroke(Color.RED);
        //线条宽度
        line.setStrokeWidth(10);
        //线条二端的角度  StrokeLineCap.ROUND 圆角
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        //定义路径段满足时应用的装饰
        line.setStrokeLineJoin(StrokeLineJoin.ROUND);

        Line line2 = new Line();
        line2.setStartX(100.0f);
        line2.setStartY(100.0f);
        line2.setEndX(300.0f);
        line2.setEndY(100.0f);
        //线条色彩
        line2.setStroke(Color.RED);
        //线条宽度
        line2.setStrokeWidth(10);
        //线条二端的角度  StrokeLineCap.ROUND 圆角
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        //定义路径段满足时应用的装饰
        line2.setStrokeLineJoin(StrokeLineJoin.ROUND);
        //定义表示短划线段长度的数组
        line2.getStrokeDashArray().addAll(25.0, 20.0, 5.0, 20.0);

        root.getChildren().addAll(line, line2);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 直线条");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

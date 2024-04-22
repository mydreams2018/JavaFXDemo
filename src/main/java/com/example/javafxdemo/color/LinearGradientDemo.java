package com.example.javafxdemo.color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LinearGradientDemo extends Application {

    /* 线性渐变
    * NO_CYCLE 定义使用终端颜色填充剩余区域的循环方法
    * REFLECT  反映渐变色开始到结束 结束后开始填充剩余区域的循环方法
    * REPEAT   定义重复渐变色以填充剩余区域的循环方法
    * */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.RED)};
        //(double startX, double startY, double endX, double endY, boolean proportional, CycleMethod cycleMethod, List<Stop> stops)
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        Rectangle r1 = new Rectangle(0, 0, 100, 100);
        r1.setFill(lg1);

        LinearGradient lg2 = new LinearGradient(125, 0, 225, 0, false, CycleMethod.REPEAT, stops);
        Rectangle r2 = new Rectangle(125, 0, 100, 100);
        r2.setFill(lg2);

        root.getChildren().addAll(r1, r2);
        Scene scene = new Scene(root);
        primaryStage.setTitle("线性渐变");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

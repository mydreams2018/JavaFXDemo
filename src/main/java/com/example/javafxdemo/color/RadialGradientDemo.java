package com.example.javafxdemo.color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RadialGradientDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Stop[] stops = new Stop[] { new Stop(0.3, Color.BLACK), new Stop(1, Color.RED)};
        /*     (聚焦角度 focusAngle, 从渐变中心到第一个颜色映射到的焦点的距离 focusDistance, 中心起点X centerX, 中心起点Y centerY, 角度 double radius,
                 boolean proportional, CycleMethod cycleMethod, List<Stop> stops)
        */
        RadialGradient rg1 = new RadialGradient(90, 30, 10, 10, 50, false, CycleMethod.NO_CYCLE, stops);
        Rectangle r1 = new Rectangle(0, 0, 100, 100);
        r1.setFill(rg1);
        // proportional = true 等比例缩放
        RadialGradient rg2 = new RadialGradient(90, 0.2, 0, 0, 0.5, true, CycleMethod.NO_CYCLE, stops);
        Rectangle r2 = new Rectangle(125, 0, 100, 100);
        r2.setFill(rg2);

        root.getChildren().addAll(r1, r2);
        Scene scene = new Scene(root);
        primaryStage.setTitle("镜像渐变");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

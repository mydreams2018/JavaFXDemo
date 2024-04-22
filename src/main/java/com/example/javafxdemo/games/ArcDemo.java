package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class ArcDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        /*
        * Arc 类表示由中心点 起始角度 (以度) 角度范围 ( 弧度的长度 ) 和 弧线类型 (ArctType.OPEN  ArctType.CHORD  ArcType.ROUND) 定义的 2D 弧形对象
        * */
        Arc arc = new Arc();
        arc.setCenterX(50.0f);
        arc.setCenterY(50.0f);
        arc.setRadiusX(50.0f);
        arc.setRadiusY(50.0f);
        //定义弧的起始角度
        arc.setStartAngle(0.0f);
        //定义弧的角度 360就是圆了
        arc.setLength(270.0f);
        //弧线类型 ROUND 圆
        arc.setType(ArcType.ROUND);

        root.getChildren().add(arc);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 弧形对象");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        System.out.println(arc.getLayoutBounds());
        System.out.println(arc.getBoundsInLocal());
        System.out.println(arc.getBoundsInParent());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

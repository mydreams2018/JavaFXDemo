package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class CircleDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Circle circle = new Circle();
        //设置圆中心点的X Y 位置  200X100Y 为圆的中心点显示
        circle.setCenterX(200.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(50.0f);
        circle.setFill(Color.RED);
        circle.setStrokeWidth(3);
        circle.setStroke(Color.BLUE);
        circle.setStrokeType(StrokeType.CENTERED);
        circle.setPickOnBounds(true);
        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event);
            }
        });


        System.out.println(circle.getLayoutBounds());
        System.out.println(circle.getBoundsInLocal());
        System.out.println(circle.getBoundsInParent());


        root.getChildren().add(circle);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 圆形");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

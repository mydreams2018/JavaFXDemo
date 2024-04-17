package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CircleDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setBackground(Background.fill(Color.GREEN));

        //手动触发指定的事件
//        Event.fireEvent(EventTarget eventTarget, Event event);

        Circle circle = new Circle();
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(50.0f);
        circle.setFill(Color.RED);
        //实际上是一个矩形区域 设置矩形区域也响应事件通知
        circle.setPickOnBounds(false);
        //如果为true 那么此节点(连同其所有子代)对鼠标事件完全透明 不触发
        circle.setMouseTransparent(true);
        System.out.println(circle.mouseTransparentProperty().get());

        Button button = new Button("button");
        button.setLayoutX(300);
        button.setLayoutY(300);
        System.out.println(button.mouseTransparentProperty().get());

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event);
            }
        });

        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event);
            }
        });

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event);
            }
        });

        root.setTop(button);
        root.setCenter(circle);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Circle Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

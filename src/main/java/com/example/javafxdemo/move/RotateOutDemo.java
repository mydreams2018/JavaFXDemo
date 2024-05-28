package com.example.javafxdemo.move;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class RotateOutDemo extends Application {

    private int rotateNum = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        HBox hbox = new HBox();
        hbox.setBorder(Border.stroke(Color.GREEN));
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(200);
        rectangle.setHeight(100);
        rectangle.setLayoutX(200);
        rectangle.setLayoutY(200);

        Button button = new Button("Rotate");
        button.setOnAction(event -> {
            rectangle.setRotate(++rotateNum);
            Bounds boundsInLocal = rectangle.getBoundsInParent();
            hbox.setLayoutX(boundsInLocal.getMinX());
            hbox.setLayoutY(boundsInLocal.getMinY());
            hbox.setPrefWidth(boundsInLocal.getWidth());
            hbox.setPrefHeight(boundsInLocal.getHeight());

            System.out.println(rectangle.getLayoutBounds());
            System.out.println(rectangle.getBoundsInLocal());
            System.out.println(boundsInLocal);
            //包含旋转后放大的区域 [此XY坐标点是否有子元素]
//            System.out.println(root.contains(198, 198));
        });

        hbox.setOnMouseClicked(event -> System.out.println(event.getY()));

        root.getChildren().addAll(rectangle, button, hbox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("RotateOut Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

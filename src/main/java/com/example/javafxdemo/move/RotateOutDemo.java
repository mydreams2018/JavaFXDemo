package com.example.javafxdemo.move;

import com.example.javafxdemo.CollisionDetection;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
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
            Bounds boundsInParent = rectangle.getBoundsInParent();
            hbox.setLayoutX(boundsInParent.getMinX());
            hbox.setLayoutY(boundsInParent.getMinY());
            hbox.setPrefWidth(boundsInParent.getWidth());
            hbox.setPrefHeight(boundsInParent.getHeight());
            //包含旋转后放大的区域 [此XY坐标点是否有子元素]
//            System.out.println(root.contains(198, 198));
        });

        hbox.setOnMouseClicked(event -> System.out.println(event.getY()));
        root.getChildren().addAll(rectangle, button, hbox);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                button.setLayoutY(button.getLayoutY() - 1);
            } else if (event.getCode() == KeyCode.S) {
                button.setLayoutY(button.getLayoutY() + 1);
            } else if (event.getCode() == KeyCode.D) {
                button.setLayoutX(button.getLayoutX() + 1);
            } else if (event.getCode() == KeyCode.A) {
                button.setLayoutX(button.getLayoutX() - 1);
            }
            System.out.println(CollisionDetection.checkCollision(button, rectangle) && CollisionDetection.isCollision(button, rectangle));
        });
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

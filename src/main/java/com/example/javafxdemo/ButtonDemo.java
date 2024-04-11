package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
    /*
    * Group 自由布局
    * */
    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Button buttonA = new Button("ButtonA");
        Button buttonB = new Button("ButtonB");
        Button buttonC = new Button("ButtonC");

//        buttonA.setBackground(Background.fill(Paint.valueOf("#8FBC8F")));
//        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("red"), BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(2));
//        buttonA.setBorder(new Border(borderStroke));
        buttonC.setTextFill(Paint.valueOf("red"));
        root.getChildren().addAll(buttonA, buttonB, buttonC);
        buttonB.setLayoutX(80);
        buttonC.setLayoutX(150);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setTitle("Button Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

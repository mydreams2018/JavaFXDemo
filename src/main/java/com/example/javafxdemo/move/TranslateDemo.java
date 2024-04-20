package com.example.javafxdemo.move;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

/*
 *  Translate  x|y|z表示位移
 * 1.不改变原有组件所占用的位置
 * */
public class TranslateDemo extends Application {

    private int translateX, translateY, translateZ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        Button buttonA = new Button("Translate");
        Button buttonB = new Button("Translate x");
        Button buttonC = new Button("Translate y");
        Button buttonD = new Button("Translate z");
        buttonB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonA.setTranslateX(translateX += 10);
                System.out.println(buttonA.getLayoutX());
                System.out.println(buttonA.getLayoutY());

                Transform localToParentTransform = buttonA.getLocalToParentTransform();
                System.out.println(localToParentTransform.getTx() + ", " + localToParentTransform.getTy());

            }
        });
        buttonC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonA.setTranslateY(translateY += 10);
            }
        });
        //没有开启3D效果Z不起效
        buttonD.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonA.setTranslateY(translateZ += 10);
            }
        });
        root.getChildren().addAll(buttonA, buttonB, buttonC, buttonD);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("FlowPane Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

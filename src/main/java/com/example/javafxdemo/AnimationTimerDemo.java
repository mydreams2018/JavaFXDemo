package com.example.javafxdemo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AnimationTimerDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Button button = new Button("Click me");

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //启动后不停的调用 每一帧都会调用此方法 默认1秒60帧
                System.out.println(now);
                //JavaFX Application Thread UI线程
                System.out.println(Thread.currentThread());
            }
        };

        root.getChildren().add(button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Transition Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();

        animationTimer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

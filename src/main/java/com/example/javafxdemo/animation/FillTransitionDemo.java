package com.example.javafxdemo.animation;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class FillTransitionDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Rectangle rect = new Rectangle(100, 40, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        //色彩填充动画
        FillTransition ft = new FillTransition(Duration.millis(3000), rect, Color.RED, Color.BLUE);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        ft.play();

        root.getChildren().add(rect);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Transition Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ScrollPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        ScrollPane root = new ScrollPane();
        Rectangle rect = new Rectangle(300, 300, Color.RED);
        root.setPrefSize(200, 200);
        root.setContent(rect);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Screen screen = Screen.getPrimary();
        //屏幕的高宽
        Rectangle2D bounds1 = screen.getBounds();
        System.out.println(bounds1);
        //可视的屏幕高宽
        Rectangle2D bounds = screen.getVisualBounds();
        System.out.println(bounds);

        Platform.exit();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

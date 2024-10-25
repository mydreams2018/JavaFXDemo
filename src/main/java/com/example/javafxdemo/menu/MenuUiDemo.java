package com.example.javafxdemo.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuUiDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        KnightMenu knightMenu = new KnightMenu();



        Scene scene = new Scene(knightMenu.getMeunPane());
        primaryStage.setScene(scene);
        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);
        primaryStage.setTitle("menu");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

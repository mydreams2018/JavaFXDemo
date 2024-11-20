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
        System.out.println(knightMenu.getMeunPane().prefWidth(-1));
        System.out.println(knightMenu.getMeunPane().prefHeight(-1));
        knightMenu.refreshLayout(1366,768);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        //在屏幕中的位置 默认居中
//        stage.setX(300);
        stage.setScene(scene);
        //StageStyle.DECORATED, StageStyle.UNDECORATED, StageStyle.TRANSPARENT,StageStyle.UTILITY
        stage.initStyle(StageStyle.UTILITY);
        System.out.println(stage.getMaxWidth());
        //触发事什
        stage.setOnCloseRequest(System.out::println);
        System.out.println(stage.getFullScreenExitHint());
        //事件过滤  MouseEvent KeyEvent
        stage.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("addEventFilter");
            }
        });
        //添加事件
        stage.addEventHandler(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("addEventHandler:"+event.getCode());
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
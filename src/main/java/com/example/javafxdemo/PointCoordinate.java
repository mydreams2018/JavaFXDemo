package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PointCoordinate extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();

        Button button = new Button("x point coordinate");
        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //事件源
                System.out.println(event.getSource());
                //事件目标  可能是按钮上的文化字 就是Text类型的
                System.out.println(event.getTarget());
                //事件类型
                System.out.println(event.getEventType());
                //距离上级组件的X值
                System.out.println(event.getX());
                //距离窗体的X值
                System.out.println(event.getSceneX());
                //距离屏幕的X值
                System.out.println(event.getScreenX());

                //ctrl 是否同时按下状态
                System.out.println(event.isControlDown());
            }
        });
        AnchorPane.setLeftAnchor(button, 50.0);
        AnchorPane.setTopAnchor(button, 50.0);
        root.getChildren().add(button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("MenuBar Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

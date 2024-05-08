package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class PopupDemo extends Application {

    /*
    * Popup是场景图的一个特殊的类似窗口的容器 弹出窗口没有装饰 固定位置弹出窗口
    * 本质上充当一个没有装饰 透明且具有空填充的专用场景窗口
     * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Popup popup = new Popup();
        popup.setAnchorLocation(PopupWindow.AnchorLocation.WINDOW_TOP_RIGHT);
        popup.getContent().addAll(new Label("Hello World"),new Button("dfsdf"));
        popup.setAutoHide(false);
        Button button = new Button("Button");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.show(primaryStage);
            }
        });

        root.getChildren().add(button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("PopupDemo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

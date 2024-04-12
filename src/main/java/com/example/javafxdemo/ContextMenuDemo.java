package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ContextMenuDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Button button = new Button("Click me");
        //绑定右键菜单
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(new MenuItem("ContextMenu Item"), new SeparatorMenuItem(),new MenuItem("ContextMenu Item"));
        button.setContextMenu(contextMenu);
        button.setOnContextMenuRequested(event -> System.out.println("右键菜单触发"));

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

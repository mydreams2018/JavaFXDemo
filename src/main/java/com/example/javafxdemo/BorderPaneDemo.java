package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class BorderPaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        root.setBackground(Background.fill(Paint.valueOf("red")));
        //内边距
        root.setPadding(new Insets(10, 10, 10, 10));

        VBox vboxTop = new VBox();
        vboxTop.getChildren().add(new Label("vboxTop"));
        vboxTop.setBackground(Background.fill(Paint.valueOf("green")));
        //对齐方式
        vboxTop.setAlignment(Pos.TOP_CENTER);

        VBox vboxBottom = new VBox();
        vboxBottom.getChildren().add(new Label("vboxBottom"));
        vboxBottom.setBackground(Background.fill(Paint.valueOf("green")));
        vboxBottom.setAlignment(Pos.BOTTOM_CENTER);

        HBox hboxLeft = new HBox();
        hboxLeft.getChildren().add(new Label("hboxLeft"));
        hboxLeft.setBackground(Background.fill(Paint.valueOf("yellow")));
        hboxLeft.setAlignment(Pos.CENTER_LEFT);

        HBox hboxRight = new HBox();
        hboxRight.getChildren().add(new Label("hboxRight"));
        hboxRight.setBackground(Background.fill(Paint.valueOf("yellow")));
        hboxRight.setAlignment(Pos.CENTER_RIGHT);

        Group center = new Group();
        center.getChildren().addAll(new Button("center"));


        root.setTop(vboxTop);
        root.setBottom(vboxBottom);
        root.setLeft(hboxLeft);
        root.setRight(hboxRight);
        root.setCenter(center);
        //外边距
        BorderPane.setMargin(vboxBottom, new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("BorderPane Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

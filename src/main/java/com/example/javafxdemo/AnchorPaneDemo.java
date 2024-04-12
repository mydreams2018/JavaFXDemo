package com.example.javafxdemo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class AnchorPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Group root = new Group();

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(300);
        anchorPane.setPrefHeight(300);
        anchorPane.setLayoutX(50);
        anchorPane.setLayoutY(50);
        anchorPane.setBackground(Background.fill(Paint.valueOf("green")));
        TextField tf = new TextField();
        anchorPane.getChildren().add(tf);
        AnchorPane.setLeftAnchor(tf,20.0);
        AnchorPane.setBottomAnchor(tf,20.0);
        /*
        //组件消失 不占位
        tf.setManaged(false);
        //组件隐藏 占位
        tf.setVisible(false);
        //组件透明 占位
        tf.setOpacity(0);
        * */
        root.getChildren().add(anchorPane);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("TextLable Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

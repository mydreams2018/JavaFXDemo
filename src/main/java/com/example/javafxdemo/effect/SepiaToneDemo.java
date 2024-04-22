package com.example.javafxdemo.effect;

import com.example.javafxdemo.HelloApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SepiaToneDemo extends Application {

    /*
    * 一种产生罗非鱼色调效果的过滤器 类似于古董照片
    * */

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        SepiaTone sepiaTone = new SepiaTone();
        //级别值 用于控制 sepia 效应的强度 0~1
        sepiaTone.setLevel(0.7);

        Image image = new Image(HelloApplication.class.getResource("R-C.jpg").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setEffect(sepiaTone);

        root.getChildren().add(imageView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("古董照片 色调");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

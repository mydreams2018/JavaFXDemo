package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GaussianBlurDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        GaussianBlur boxBlur = new GaussianBlur();
        //高斯模糊效应 越大越糊
        boxBlur.setRadius(5);

        Text text = new Text();
        text.setText("Blurry Text!");
        text.setFill(Color.web("0x3b596d"));
        text.setEffect(boxBlur);
        text.setFont(Font.font(null, FontWeight.BOLD, 50));

        root.getChildren().add(text);
        Scene scene = new Scene(root);
        primaryStage.setTitle("模糊 demo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

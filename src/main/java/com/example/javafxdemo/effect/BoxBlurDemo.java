package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoxBlurDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        BoxBlur boxBlur = new BoxBlur();
        boxBlur.setWidth(3);
        boxBlur.setHeight(3);
        //迭代模糊效应以提高其 "质量" 或 " 平滑度 "的次数  迭代结果的 3 倍将高斯蓝调的质量近似于3%以内
        boxBlur.setIterations(1);

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

package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BloomDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Bloom bloom = new Bloom();
        //阈值控制将被制成辉光的像素的最小光度值  0~1 默认0.3
        bloom.setThreshold(0.5);

        Glow glow = new Glow();
        //电平值 控制辉光效应的强度  0~1 默认0.3
        glow.setLevel(0.5);

        Rectangle rect = new Rectangle();
        rect.setWidth(160);
        rect.setHeight(80);
        rect.setFill(Color.DARKSLATEBLUE);
        rect.setEffect(glow);

        Text text = new Text();
        text.setText("发光效果 Bloom!");
        text.setFont(Font.font(null, FontWeight.BOLD, 40));
        text.setEffect(bloom);

        root.getChildren().addAll(rect, text);
        Scene scene = new Scene(root);
        primaryStage.setTitle("发光效果 demo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

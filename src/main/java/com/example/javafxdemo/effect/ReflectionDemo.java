package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReflectionDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        Reflection reflection = new Reflection();
        //在反射中可视的输入的分数 例如值 0.5 表示只有输入的底部一半在反射中可视 0~1
        reflection.setFraction(0.7);
        //底部不透明度值 这是其底部的反射的不透明度 0~1
        reflection.setBottomOpacity(0.5);
        //顶部偏移调整 即原组件底部与反射顶部之间的距离
        reflection.setTopOffset(0);
        //顶部透明度 它是其顶端反射的透明度 0~1
        reflection.setTopOpacity(0.8);

        Text text = new Text();
        text.setCache(true);
        text.setText("Reflections on JavaFX...");
        text.setFill(Color.web("0x3b596d"));
        text.setFont(Font.font(null, FontWeight.BOLD, 40));
        text.setEffect(reflection);

        root.getChildren().addAll(text,new Button("Reflections"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("倒影 反射图片");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

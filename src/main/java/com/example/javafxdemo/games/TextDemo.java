package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TextDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Text t = new Text();
        t.setFont(new Font(20));
        //定义用户空间坐标中文本的宽度约束
//        t.setWrappingWidth(200);
        //字体间隔
        t.setLineSpacing(2);
        t.setTextAlignment(TextAlignment.JUSTIFY);
        t.setText("The quick brown fox jumps over the lazy dog");

        root.getChildren().add(t);
        Scene scene = new Scene(root);
        primaryStage.setTitle("文本");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

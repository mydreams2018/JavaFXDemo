package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MotionBlurDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        MotionBlur motionBlur = new MotionBlur();
        //模糊内核的半径
        motionBlur.setRadius(30);
        //移动效果的角度 ( 度数 )
        motionBlur.setAngle(-15.0);
        Text text = new Text();
        text.setX(20.0);
        text.setY(100.0);
        text.setText("Motion!");
        text.setFill(Color.web("0x3b596d"));
        text.setFont(Font.font(null, FontWeight.BOLD, 60));
        text.setEffect(motionBlur);

        root.getChildren().add(text);
        Scene scene = new Scene(root);
        primaryStage.setTitle("运动模糊 demo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

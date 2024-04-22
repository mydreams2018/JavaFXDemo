package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LightingDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        Light.Distant light = new Light.Distant();
        //光的方位 在 XY 平面上 方位是光源的方向角 默认45
        light.setAzimuth(-135.0);
        //光的高度 仰角是 YZ 平面上光源的方向角度 度数 默认45
        light.setElevation(45);
        /*
        * 光照效果 一个模拟一个光源照射在给定内容上的效果 它可以用来给平面物体一个更逼真的三维外观
        * */
        Lighting lighting = new Lighting();
        //此照明效果的光源
        lighting.setLight(light);
        //表面刻度因子 0~ 10 默认1.5
        lighting.setSurfaceScale(5.0);
        //扩散常数 0~2 默认1
        lighting.setDiffuseConstant(2);
        //镜面常数 0~2 默认0.3
        lighting.setSpecularConstant(1);
        //镜面指数 0~40 默认20
        lighting.setSpecularExponent(20);

        Text text = new Text();
        text.setText("JavaFX!");
        text.setFill(Color.STEELBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 60));
        text.setX(10.0);
        text.setY(10.0);
        text.setTextOrigin(VPos.TOP);
        text.setEffect(lighting);

        root.getChildren().add(text);
        Scene scene = new Scene(root);
        primaryStage.setTitle("光源照射效果");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

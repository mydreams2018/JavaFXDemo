package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageDemoTwo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(0.1);
        colorAdjust.setHue(-0.05);
        colorAdjust.setBrightness(0.1);
        colorAdjust.setSaturation(0.2);

        DropShadow dropShadow = new DropShadow();
//        dropShadow.setRadius(100);
//        dropShadow.setOffsetX(3.0);
//        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.RED);

        Glow glow = new Glow(0.9);

        Image image = new Image(getClass().getResourceAsStream("1.png"));
        //ImageView 是用于对装入图像类的图像进行绘图的节点
        ImageView iv3 = new ImageView();
        iv3.setImage(image);
        iv3.setEffect(dropShadow);
        root.getChildren().add(iv3);

        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setAlwaysOnTop(false);//永远在顶层
        stage.setFullScreen(false);//设置全屏
        stage.getIcons().add(new Image(getClass().getResourceAsStream("favicon.ico")));
        stage.setResizable(true);//固定大小
        stage.setMaximized(false);//最大化窗口
        stage.setTitle("ImageDemo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

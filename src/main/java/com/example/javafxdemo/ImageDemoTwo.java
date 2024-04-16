package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageDemoTwo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        HBox box = new HBox();

        Image image = new Image(getClass().getResourceAsStream("720w.png"));
        //ImageView 是用于对装入图像类的图像进行绘图的节点
        ImageView iv3 = new ImageView();
        iv3.setImage(image);
        Rectangle2D viewportRect = new Rectangle2D(40, 35, image.getWidth() - 40, image.getHeight() - 35);
        iv3.setViewport(viewportRect);

        System.out.println(iv3.prefHeight(-1));//原图267  232
        System.out.println(iv3.prefWidth(-1));//原图640   600

        Button button = new Button("setRotate");
        button.setOnAction(new EventHandler<>() {

            private double rotate = 0;

            @Override
            public void handle(ActionEvent event) {
                iv3.setRotate(rotate += 10);
            }
        });

        box.getChildren().addAll(iv3, button);
        root.getChildren().add(box);

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

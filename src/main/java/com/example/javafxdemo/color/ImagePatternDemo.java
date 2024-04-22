package com.example.javafxdemo.color;

import com.example.javafxdemo.HelloApplication;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class ImagePatternDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();


        Image dots = new Image(HelloApplication.class.getResource("R-C.jpg").toExternalForm());
        Image flower = new Image(HelloApplication.class.getResource("720w.png").toExternalForm());
        Image favicon = new Image(HelloApplication.class.getResource("favicon.ico").toExternalForm());

        //创建由 x y 坐标数组定义的多边形
        Polygon p = new Polygon();
        p.setLayoutX(10);
        p.setLayoutY(10);
        p.getPoints().add(50.0);
        p.getPoints().add(0.0);
        p.getPoints().add(100.0);
        p.getPoints().add(100.0);
        p.getPoints().add(0.0);
        p.getPoints().add(100.0);
        //proportional = true 等比例缩放
        p.setFill(new ImagePattern(flower, 0, 0, 1, 1, true));
        p.setPickOnBounds(true);
        p.setOnMouseClicked(event -> System.out.println(event));

        root.getChildren().add(p);

        //创建由 x y 坐标数组定义的多边形
        Polygon p2 = new Polygon();
        p2.setLayoutX(10);
        p2.setLayoutY(120);
        p2.getPoints().add(50.0);
        p2.getPoints().add(0.0);
        p2.getPoints().add(100.0);
        p2.getPoints().add(100.0);
        p2.getPoints().add(0.0);
        p2.getPoints().add(100.0);
        //proportional = false 把图片压缩到指定的宽高
        p2.setFill(new ImagePattern(flower, 0, 0, 100, 100, false));
        root.getChildren().add(p2);
//
        //类创建以像素为单位测量的指定半径和中心位置的新圆
        Circle circ = new Circle(50);
        circ.setTranslateX(120);
        circ.setTranslateY(10);
        circ.setCenterX(50);
        circ.setCenterY(50);
        //0.5压缩  上下左右  4个图片显示
        circ.setFill(new ImagePattern(dots, 0, 0, 0.5, 0.5, true));
        root.getChildren().add(circ);

        Circle circ2 = new Circle(50);
        circ2.setTranslateX(120);
        circ2.setTranslateY(120);
        circ2.setCenterX(50);
        circ2.setCenterY(50);
        //压缩50*50   上下左右  4个图片显示
        circ2.setFill(new ImagePattern(dots, 0, 0, 50, 50, false));
        root.getChildren().add(circ2);


        Circle circ3 = new Circle(50);
        circ3.setTranslateX(220);
        circ3.setTranslateY(10);
        circ3.setCenterX(50);
        circ3.setCenterY(50);
        //原始图片较小 按原始大小铺满填充
        circ3.setFill(new ImagePattern(favicon, 0, 0, favicon.getWidth(), favicon.getHeight(), false));
        root.getChildren().add(circ3);

        Scene scene = new Scene(root);
        primaryStage.setTitle("ImagePattern Demo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

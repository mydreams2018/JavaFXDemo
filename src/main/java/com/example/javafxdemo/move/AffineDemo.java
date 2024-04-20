package com.example.javafxdemo.move;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

/*
 *  Affine  x|y|z 表示仿射变换
 * 1.不改变原有组件所占用的位置
 *
 * */
public class AffineDemo extends Application {

    /*
    * 对于简单的变换应用程序开发者 应该使用特定的 Translate Scal  Rotate  Shear 这些变换更轻量级
    * */
    private Affine affine = new Affine(-1, 0, 0, 0, 1, 0);

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setBackground(Background.fill(Color.GREEN));
        ImageView imgView = new ImageView(getClass().getResource("player.png").toExternalForm());
        Button buttonB = new Button("Affine x");
        Button buttonC = new Button("Affine y");
        Button buttonD = new Button("Affine z");
        //仿射变换
        imgView.getTransforms().add(affine);
        affine.setTx(imgView.prefWidth(-1));
        buttonB.setOnAction(event -> {
            Transform localToParentTransform = imgView.getLocalToParentTransform();
            System.out.println(localToParentTransform);
            //仿射变换的 原左上角X|Y坐标
            System.out.println(localToParentTransform.getTx() + " " + localToParentTransform.getTy());
            Bounds boundsInParent = imgView.getBoundsInParent();
            /*
            仿射变换 找到的最小 X Y 点
            仿射变换 找到的最大 X Y 点
            根据上边的信息 画出一个矩形
            */
            System.out.println(boundsInParent.getMinX() + " " + boundsInParent.getMinY());
            System.out.println(boundsInParent.getMaxX() + " " + boundsInParent.getMaxY());
            //旋转后的宽高
            System.out.println("仿射变换后的宽高:" + boundsInParent.getWidth() + " " + boundsInParent.getHeight());
            System.out.println();
        });

        root.getChildren().addAll(imgView, buttonB, buttonC, buttonD);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Affine Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

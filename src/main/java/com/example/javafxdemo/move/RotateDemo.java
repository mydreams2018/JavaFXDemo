package com.example.javafxdemo.move;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

/*
 *  Rotate  x|y|z 表示旋转
 *  旋转的中心点
 * 1.不改变原有组件所占用的位置
 *
 * */
public class RotateDemo extends Application {

    private Rotate rotate = new Rotate(0, 0, 0);
    double angle = 0;
    double transX = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setPadding(new Insets(100, 0, 0, 100));
        root.setBackground(Background.fill(Color.GREEN));
        Button buttonA = new Button("Rotate");
        Button buttonB = new Button("Rotate x");
        Button buttonC = new Button("Rotate y");
        Button buttonD = new Button("Rotate z");
        //绑定缩放组件
        buttonA.getTransforms().add(rotate);
        buttonA.getTransforms().add(new Scale(0.9,1));
        buttonB.setOnAction(event -> {
            rotate.setAngle(angle -= 10);
            Transform localToParentTransform = buttonA.getLocalToParentTransform();
            System.out.println(localToParentTransform);
            //旋转后的原左上角X|Y坐标
            System.out.println(localToParentTransform.getTx() + " " + localToParentTransform.getTy());
            Bounds boundsInParent = buttonA.getBoundsInParent();
            /*
            旋转后 找到的最小 X Y 点
            旋转后 找到的最大 X Y 点
            根据上边的信息 画出一个矩形
            */
            System.out.println(boundsInParent.getMinX() + " " + boundsInParent.getMinY());
            System.out.println(boundsInParent.getMaxX() + " " + boundsInParent.getMaxY());
            //旋转后的宽高
            System.out.println("旋转后的宽高:" + boundsInParent.getWidth() + " " + boundsInParent.getHeight());
            System.out.println();
        });

        buttonC.setOnAction(event -> {
            Transform localToParentTransform = buttonA.getLocalToParentTransform();
            System.out.println(localToParentTransform);
            //旋转后的原左上角X|Y坐标
            Bounds boundsInParent = buttonA.getBoundsInParent();
            /*
            旋转后 找到的最小 X Y 点
            旋转后 找到的最大 X Y 点
            根据上边的信息 画出一个矩形
            */
            System.out.println(boundsInParent.getMinX() + " " + boundsInParent.getMinY());
            System.out.println(boundsInParent.getMaxX() + " " + boundsInParent.getMaxY());
            System.out.println(boundsInParent.getCenterX() + " " + boundsInParent.getCenterY());
            //旋转后的宽高
            System.out.println("旋转后的宽高:" + boundsInParent.getWidth() + " " + boundsInParent.getHeight());
            System.out.println("原始宽高:" + buttonA.getWidth() + " " + buttonA.getHeight());
            System.out.println();
        });

        buttonD.setOnAction(event -> {
            buttonA.getTransforms().forEach(System.out::println);
            Transform localToParentTransform = buttonA.getLocalToParentTransform();
            System.out.println(localToParentTransform);
            Bounds boundsInParent = buttonA.getBoundsInParent();
            /*
            旋转后 找到的最小 X Y 点
            旋转后 找到的最大 X Y 点
            根据上边的信息 画出一个矩形
            */
            System.out.println("旋转后的min=" + boundsInParent.getMinX() + " " + boundsInParent.getMinY());
            System.out.println("旋转后的max=" + boundsInParent.getMaxX() + " " + boundsInParent.getMaxY());
            System.out.println("旋转后的center=" + boundsInParent.getCenterX() + " " + boundsInParent.getCenterY());
            //旋转后的宽高
            System.out.println("旋转后的宽高:" + boundsInParent.getWidth() + " " + boundsInParent.getHeight());
            System.out.println("原始宽高:" + buttonA.getWidth() + " " + buttonA.getHeight());
            boundsInParent.contains(50,100);
            System.out.println();
        });

        root.getChildren().addAll(buttonA, buttonB, buttonC, buttonD);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("FlowPane Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

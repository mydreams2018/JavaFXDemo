package com.example.javafxdemo.animation;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class RotateTransitionDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Rectangle rect = new Rectangle(0, 0, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setFill(Color.VIOLET);

        /*
        *  axis 旋转轴线
        * fromAngle 从什么角度
        * toAngle 到什么角度
        * byAngle 增量角度
        * */
        RotateTransition rt = new RotateTransition(Duration.millis(3000), rect);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);
        rt.setAxis(new Point3D(50,50,0));
        rt.play();

        root.getChildren().add(rect);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Transition Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PerspectiveTransformDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        PerspectiveTransform perspectiveTrasform = new PerspectiveTransform();
        perspectiveTrasform.setUlx(10.0);
        perspectiveTrasform.setUly(10.0);
        perspectiveTrasform.setUrx(310.0);
        perspectiveTrasform.setUry(40.0);
        perspectiveTrasform.setLrx(310.0);
        perspectiveTrasform.setLry(60.0);
        perspectiveTrasform.setLlx(10.0);
        perspectiveTrasform.setLly(90.0);

        /*
        根组件设置 透视变换可以将任意四边形映射到另一个任意四边形 同时保留行的直线度  与仿射变换不同 源中的线的平行度不一定保留在输出中
        请注意 此效果不会调整输入事件的坐标或度量节点上的包含的任何方法  当节点具有 PerspectiveTransform 效果时 将取消选择鼠标拾取和包含方法的结果
        * */
        Group g = new Group();
        g.setEffect(perspectiveTrasform);
        g.setCache(true);

        Rectangle rect = new Rectangle();
        rect.setX(10.0);
        rect.setY(10.0);
        rect.setWidth(280.0);
        rect.setHeight(80.0);
        rect.setFill(Color.web("0x3b596d"));

        Text text = new Text();
        text.setX(20.0);
        text.setY(65.0);
        text.setText("Perspective");
        text.setFill(Color.ALICEBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 36));

        g.getChildren().addAll(rect, text);
        Scene scene = new Scene(g);
        primaryStage.setTitle("透视变换");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class CalculateDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        Rectangle r = new Rectangle();
        r.setWidth(200);
        r.setHeight(100);
        r.setFill(Color.RED);

        Rectangle r1 = new Rectangle();
        r1.setWidth(200);
        r1.setHeight(100);
        r1.setFill(Color.BLUE);

        Group group = new Group();
        group.getChildren().addAll(r,r1);

        /*
        *  intersect相并  在最终操作之前 输入形状的区域被转换为其各自最顶部父节点的父坐标空间
        *              计算二个图形相交部分返回新图形   生成的形状将仅包含两个输入形状中包含的区域
        *  subtract排除 在最终操作之前 输入形状的区域被转换为其各自最顶部父节点的父坐标空间
        *               返回通过从第一个形状中减去指定的第二个形状而创建的新形状
        *                   所形成的形状将包括仅包含在第一形状中有 而第二形状中没有的区域
        *  union合并   在最终操作之前 输入形状的区域被转换为其各自最顶部父节点的父坐标空间
        *               生成的形状将包括包含在任何输入形状中的区域
        * */
        HBox hbox = new HBox();
        Button btn1 = new Button("intersect");
        Button btn2 = new Button("subtract");
        Button btn3 = new Button("union");
        hbox.getChildren().addAll(btn1, btn2, btn3);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Shape intersect = Shape.intersect(r, r1);
                intersect.setStroke(Color.YELLOW);
                intersect.setStrokeWidth(2);
                root.setCenter(intersect);
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Shape subtract = Shape.subtract( r1, r);
                subtract.setStroke(Color.YELLOW);
                subtract.setStrokeWidth(2);
                root.setCenter(subtract);
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Shape union = Shape.union( r1, r);
                union.setStroke(Color.YELLOW);
                union.setStrokeWidth(2);
                root.setCenter(union);
            }
        });

        root.setTop(hbox);
        root.setLeft(group);

        Scene scene = new Scene(root);
        primaryStage.setTitle("图形计算");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

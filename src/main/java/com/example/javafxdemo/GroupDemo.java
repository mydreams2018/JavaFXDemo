package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/* autoSizeChildren
* 控制该组是否在布局过程中自动将任何托管的可调整大小的子级调整为其首选大小
* 如果设置为 false则应用程序负责设置该组的可调整大小的子节点的大小 否则此类节点可能最终宽度/高度为零并且不可见
* 此变量对不可调整大小的内容节点(形状、文本等)没有影响
*
* Group 不能设置高宽由子类撑开布局
* */

public class GroupDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        root.setAutoSizeChildren(false);
        for (int i = 0; i < 5; i++) {
            Rectangle r = new Rectangle();
            r.setY(i * 20);
            r.setWidth(600);
            r.setHeight(10);
            r.setFill(Color.RED);
            r.setOnMouseClicked(event -> {
                System.out.println("prefWidth - 1 = " + root.prefWidth(Region.USE_COMPUTED_SIZE));
                System.out.println("prefWidth - 2 = " + root.prefWidth(Region.USE_PREF_SIZE));
                System.out.println("prefHeight -1 = "+ root.prefHeight(Region.USE_COMPUTED_SIZE));
                System.out.println("prefHeight -2 = " + root.prefHeight(Region.USE_PREF_SIZE));

                System.out.println(root.minWidth(Region.USE_COMPUTED_SIZE));
                System.out.println(root.minWidth(Region.USE_PREF_SIZE));

                System.out.println(root.maxWidth(Region.USE_COMPUTED_SIZE));
                System.out.println(root.maxWidth(Region.USE_PREF_SIZE));

                System.out.println(root.minHeight(Region.USE_PREF_SIZE));
                System.out.println(root.minHeight(Region.USE_PREF_SIZE));

                System.out.println(root.maxHeight(Region.USE_PREF_SIZE));
                System.out.println(root.maxHeight(Region.USE_PREF_SIZE));
            });
            root.getChildren().add(r);
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setTitle("Group Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

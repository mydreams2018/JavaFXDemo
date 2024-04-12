package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class FlowPaneDemo extends Application {
    /*
    * 有自动排列的效果
    * */
    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane root = new FlowPane();
        root.getChildren().addAll(new Button("one"), new Button("two"), new Button("three"),
                new Button("four"), new Button("five"));
        root.setAlignment(Pos.TOP_CENTER);

        //组件间距 类似 space
        root.setHgap(10);
        root.setVgap(10);
        //模排 竖排
        root.setOrientation(Orientation.HORIZONTAL);

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

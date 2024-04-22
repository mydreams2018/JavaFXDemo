package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class SvgPathDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        /*
        * https://www.w3.org/TR/SVG/paths.html
        * */
        SVGPath svg = new SVGPath();
        svg.setContent("M40,60 C42,48 44,30 25,32");

        root.getChildren().add(svg);
        Scene scene = new Scene(root);
        primaryStage.setTitle("svg 路径 图像绘制");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TestDemo extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();

        HBox hBoxA = new HBox();
        hBoxA.getChildren().addAll(new Button("hBoxA"), new Button("hBoxB"));

        HBox hBoxB = new HBox();
        Button buttonE = new Button("buttonE");
        hBoxB.getChildren().addAll(new Button("hBoxC"), new Button("hBoxD"), buttonE);

        root.add(hBoxA, 0, 0);
        root.add(hBoxB, 0, 1);
        //此节点在布局期间是否可以由其父节点调整大小
        System.out.println(hBoxB.isResizable());

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();

        System.out.println(hBoxB.getPrefWidth());//-1.0
        //父节点调整大小
        System.out.println(hBoxB.getWidth());//107.2

        Bounds layoutBounds = buttonE.getLayoutBounds();
        // [minX:0.0, minY:0.0, minZ:0.0, width:62, height:23, depth:0.0, maxX:62, maxY:23, maxZ:0.0]
        //本身的边界 不带效果
        System.out.println(layoutBounds);
        //[minX:0.0, minY:0.0, minZ:0.0, width:62, height:24, depth:0.0, maxX:62, maxY:24, maxZ:0.0]
        //带效果的边界 会比本身的边界更大些
        System.out.println(buttonE.getBoundsInLocal());
        //[minX:107, minY:0.0, minZ:0.0, width:62, height:24, depth:0.0, maxX:169, maxY:24, maxZ:0.0]
        //上级的边界
        System.out.println(buttonE.getBoundsInParent());

        // Point2D 相对Scene的位置  最小[x = 107, y = 23]
        Point2D boundsMin = buttonE.localToScene(layoutBounds.getMinX(), layoutBounds.getMinY());
        System.out.println(boundsMin);
        //Point2D 相对Scene的位置 最大[x = 169, y = 46]
        Point2D boundsMax = buttonE.localToScene(layoutBounds.getMaxX(), layoutBounds.getMaxY());
        System.out.println(boundsMax);
    }
}

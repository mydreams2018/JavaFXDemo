package com.example.javafxdemo.move;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

/*
 *  Scale  x|y|z 表示缩放
 *  缩放的中心点
 * 1.不改变原有组件所占用的位置
 *
 * */
public class ScaleDemo extends Application {

    private Scale scale = new Scale(1, 1);
    double scaleX = 1, scaleY = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        Button buttonA = new Button("Scale");
        Button buttonB = new Button("Scale x");
        Button buttonC = new Button("Scale y");
        Button buttonD = new Button("Scale z");
        //绑定缩放组件
        scale.pivotXProperty().bind(buttonA.widthProperty());
        scale.pivotYProperty().bind(buttonA.heightProperty());
        buttonA.getTransforms().add(scale);

        buttonB.setOnAction(event -> {
            scale.setX(scaleX -= 0.1);
            scale.setY(scaleY -= 0.1);
            Transform localToParentTransform = buttonA.getLocalToParentTransform();
            System.out.println(localToParentTransform);
            System.out.println(localToParentTransform.getTx() + " " + localToParentTransform.getTy());

            Bounds boundsInParent = buttonA.getBoundsInParent();
            System.out.println(boundsInParent.getMinX() + " " + boundsInParent.getMinY());
            //缩放后的宽高
            System.out.println(boundsInParent.getWidth() + " " + boundsInParent.getHeight());
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

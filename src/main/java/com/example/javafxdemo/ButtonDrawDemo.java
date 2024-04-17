package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ButtonDrawDemo extends Application {

    private boolean isMove = false;
    private int initX, initY, layoutX, layoutY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        Button button = new Button("Button");
        //以该节点为手势源启动完整的按拖动释放手势
/*        button.setOnDragDetected(event -> button.startFullDrag());
        button.setOnMouseDragReleased(event -> {
                    //只有在组件本身上释放才有效果
                    System.out.println("onMouseDragReleased");
                }
        );*/

        button.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                if (!isMove) {
                    isMove = true;
                }
                if (initX == 0 && initY == 0) {
                    System.out.println("init press");
                    Button source = (Button) event.getSource();
                    initX = (int) event.getScreenX();
                    initY = (int) event.getScreenY();
                    layoutX = (int) source.getLayoutX();
                    layoutY = (int) source.getLayoutY();
                }
            }
        });

        button.setOnMouseReleased(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                System.out.println("init released");
                initX = 0;
                initY = 0;
                layoutX = 0;
                layoutY = 0;
                isMove = false;
            }
        });

        button.setOnMouseDragged(event -> {
            if (isMove) {
                Button source = (Button) event.getSource();
                int moveX = (int) event.getScreenX() - initX;
                int moveY = (int) event.getScreenY() - initY;
                System.out.println(moveX + ":" + moveY);

                source.setLayoutX(layoutX + moveX);
                source.setLayoutY(layoutY + moveY);

//                source.setLayoutX(source.getLayoutX() + moveX);Location error
//                source.setLayoutY(source.getLayoutY() + moveY);Location error
            }
        });
        root.getChildren().add(button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("MenuBar Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
    /*
     * Group 自由布局
     * */
    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Button buttonA = new Button("ButtonA");
        Button buttonB = new Button("ButtonB");
        Button buttonC = new Button("ButtonC");
        //停留提示
        Tooltip tooltip = new Tooltip();
        tooltip.setText("Tooltip");
        tooltip.setFont(Font.font("宋体"));
        buttonA.setTooltip(tooltip);

//        buttonA.setBackground(Background.fill(Paint.valueOf("#8FBC8F")));
//        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("red"), BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(2));
//        buttonA.setBorder(new Border(borderStroke));
        buttonC.setTextFill(Paint.valueOf("red"));
        root.getChildren().addAll(buttonA, buttonB, buttonC);
        buttonB.setLayoutX(80);
        buttonC.setLayoutX(150);
        buttonC.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            //MouseButton.PRIMARY 左键 中键 右键
            System.out.println(event.getButton().name());
            if (event.getClickCount() == 2) {
                System.out.println("Double Clicked");
            }
        });

        buttonB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("ButtonB Clicked" + event);
            }
        });
        //按键组合 快捷键
        KeyCombination keyCombination = new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN);

        Scene scene = new Scene(root);
        scene.getAccelerators().put(keyCombination, new Runnable() {
            @Override
            public void run() {
                System.out.println("组合键按下 Pressed");
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setTitle("Button Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

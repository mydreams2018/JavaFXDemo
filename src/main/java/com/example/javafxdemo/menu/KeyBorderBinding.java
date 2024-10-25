package com.example.javafxdemo.menu;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

@Getter
public class KeyBorderBinding {

    private static KeyCode moveLeftKeyCode = KeyCode.A;
    private static KeyCode moveRightKeyCode = KeyCode.D;
    private static KeyCode jumpKeyCode = KeyCode.SPACE;
    private static KeyCode attackKeyCode = KeyCode.J;
    private static KeyCode attackHighKeyCode = KeyCode.K;

    private final VBox keyBorderVBox = new VBox(20);
    private final TextField tf1 = new TextField(moveLeftKeyCode.getName());
    private final TextField tf2 = new TextField(moveRightKeyCode.getName());
    private final TextField tf3 = new TextField(jumpKeyCode.getName());
    private final TextField tf4 = new TextField(attackKeyCode.getName());
    private final TextField tf5 = new TextField(attackHighKeyCode.getName());

    public KeyBorderBinding() {
        this.initPane();
    }

    public void initPane() {
        HBox hBox1 = new HBox(10);
        tf1.setEditable(false);
        tf1.setAlignment(Pos.CENTER);
        tf1.setOnKeyPressed(keyEvent -> {
            KeyCode eventCode = keyEvent.getCode();
            if (eventCode != KeyCode.UNDEFINED) {
                moveLeftKeyCode = eventCode;
                tf1.setText(moveLeftKeyCode.getName());
            }
        });
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(new Label("左走"), tf1);

        HBox hBox2 = new HBox(10);
        tf2.setEditable(false);
        tf2.setAlignment(Pos.CENTER);
        tf2.setOnKeyPressed(keyEvent -> {
            KeyCode eventCode = keyEvent.getCode();
            if (eventCode != KeyCode.UNDEFINED) {
                moveRightKeyCode = eventCode;
                tf2.setText(moveRightKeyCode.getName());
            }
        });
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(new Label("右走"), tf2);

        HBox hBox3 = new HBox(10);
        tf3.setEditable(false);
        tf3.setAlignment(Pos.CENTER);
        tf3.setOnKeyPressed(keyEvent -> {
            KeyCode eventCode = keyEvent.getCode();
            if (eventCode != KeyCode.UNDEFINED) {
                jumpKeyCode = eventCode;
                tf3.setText(jumpKeyCode.getName());
            }
        });
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().addAll(new Label("跳跃"), tf3);

        HBox hBox4 = new HBox(10);
        tf4.setEditable(false);
        tf4.setAlignment(Pos.CENTER);
        tf4.setOnKeyPressed(keyEvent -> {
            KeyCode eventCode = keyEvent.getCode();
            if (eventCode != KeyCode.UNDEFINED) {
                attackKeyCode = eventCode;
                tf4.setText(attackKeyCode.getName());
            }
        });
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(new Label("普功"), tf4);

        HBox hBox5 = new HBox(10);
        tf5.setEditable(false);
        tf5.setAlignment(Pos.CENTER);
        tf5.setOnKeyPressed(keyEvent -> {
            KeyCode eventCode = keyEvent.getCode();
            if (eventCode != KeyCode.UNDEFINED) {
                attackHighKeyCode = eventCode;
                tf5.setText(attackHighKeyCode.getName());
            }
        });
        hBox5.setAlignment(Pos.CENTER);
        hBox5.getChildren().addAll(new Label("重功"), tf5);
        this.keyBorderVBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5);
    }
}

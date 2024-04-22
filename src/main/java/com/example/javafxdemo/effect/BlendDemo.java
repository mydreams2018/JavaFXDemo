package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BlendDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        使用其中一个预定义的 BlendModes将两个输入混合在一起的效果  重叠效果

        Blend blend = new Blend();
        blend.setMode(BlendMode.COLOR_BURN);

        ColorInput colorInput = new ColorInput();
        colorInput.setPaint(Color.STEELBLUE);
        colorInput.setX(10);
        colorInput.setY(10);
        colorInput.setWidth(100);
        colorInput.setHeight(180);

        blend.setTopInput(colorInput);
//        blend.setBottomInput();

        Rectangle rect = new Rectangle();
        rect.setWidth(220);
        rect.setHeight(100);
        Stop[] stops = new Stop[]{new Stop(0, Color.LIGHTSTEELBLUE), new Stop(1, Color.PALEGREEN)};
        LinearGradient lg = new LinearGradient(0, 0, 0.25, 0.25, true, CycleMethod.REFLECT, stops);
        rect.setFill(lg);

        Text text = new Text();
        text.setX(15);
        text.setY(65);
        text.setFill(Color.PALEVIOLETRED);
        text.setText("COLOR_BURN");
        text.setFont(Font.font(null, FontWeight.BOLD, 30));

        Group g = new Group();
        g.setEffect(blend);
        g.getChildren().addAll(rect, text);

        Scene scene = new Scene(g);
        primaryStage.setTitle("混合图层");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

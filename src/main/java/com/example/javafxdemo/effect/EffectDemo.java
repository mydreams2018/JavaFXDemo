package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EffectDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setSpacing(10);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.paddingProperty().set(new Insets(10, 0, 0, 0));

        Button button = new Button("Click me");
        //具有指定颜色 半径 偏移量 内容后面给定内容的影子阴影的高级别效应
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        //阴影偏移
        dropShadow.setOffsetX(1);
        dropShadow.setOffsetY(1);
        //设置模糊类型属性的值 Default: BlurType.THREE_PASS_BOX
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        /*
        * 阴影的传播 传播是半径的一部分 源材料的贡献将是 100% 半径的剩余部分将由模糊内核控制
        *  0.0 的传播将产生完全由模糊算法确定的阴影分布
        *  1.0 的扩散会使源极材料的不透明度向半径的极限延伸 从而使半径的透明度非常明显
        * */
        dropShadow.setSpread(0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

        Text text = new Text();
        text.setEffect(dropShadow);
        text.setCache(true);
        text.setFill(Color.web("0x3b596d"));
        text.setText("JavaFX drop shadow...");

        button.setEffect(dropShadow);
        root.getChildren().addAll(button ,text);
        Scene scene = new Scene(root);
        primaryStage.setTitle("effect demo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

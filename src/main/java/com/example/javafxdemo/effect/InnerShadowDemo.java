package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InnerShadowDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setSpacing(10);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.paddingProperty().set(new Insets(10, 0, 0, 0));

        Button button = new Button("Click me");
        //在给定内容的边缘内呈现具有指定颜色 半径和偏移量的阴影的高级别效应
        InnerShadow  innerShadow = new InnerShadow();
        innerShadow.setRadius(5.0);
        //阴影偏移
        innerShadow.setOffsetX(1);
        innerShadow.setOffsetY(1);
        /*
        * 阴影的扼流圈 扼流圈是半径的一部分 源材料的贡献将是 100% 半径的剩余部分将由模糊内核控制
        *  0.0 的扼流圈将产生完全由模糊算法确定的阴影的分布
        * 1.0 的扼流圈将产生从边缘向内的立体增长，其半径限制为半径的限制
        * */
        innerShadow.setChoke(0.2);
        //设置模糊类型属性的值 Default: BlurType.THREE_PASS_BOX
        innerShadow.setBlurType(BlurType.GAUSSIAN);
        innerShadow.setColor(Color.color(0.4, 0.5, 0.5));

//        innerShadow.setInput(Effect);效果可以叠加
        Text text = new Text();
        text.setEffect(innerShadow);
        text.setCache(true);
        text.setFill(Color.web("0x3b596d"));
        text.setText("JavaFX drop shadow...");

        button.setEffect(innerShadow);
        root.getChildren().addAll(button ,text);
        Scene scene = new Scene(root);
        primaryStage.setTitle("内阴影 demo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

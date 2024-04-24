package com.example.javafxdemo.effect;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplacementMapDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        final int width = 100;
        final int height = 100;
        FloatMap floatMap = new FloatMap();
        floatMap.setWidth(width);
        floatMap.setHeight(height);

        for (int i = 0; i < width; i++) {
            double v = (Math.sin(i / 20.0 * Math.PI) - 0.5) / 40.0;
            for (int j = 0; j < height; j++) {
                floatMap.setSamples(i, j, 0.0f, (float) v);
            }
        }
        /* 此效果不会调整输入事件的坐标  或度量节点上的包含的任何方法
           不改变原组件的位置 可以用在重叠组件 做一些轮播切换的效果
         * */
        DisplacementMap displacementMap = new DisplacementMap();
        //数据效果 字体会产生一些偏移的效果
        displacementMap.setMapData(floatMap);
        //一半可见 0~1
        displacementMap.setOffsetX(0.5);
//        displacementMap.setOffsetY(0.5);
        //将 FloatMap 中的所有 x 坐标偏移值相乘的比例因子
//        displacementMap.setScaleX(0.5);
        //自动补全不可见的区域 相当不可见的区域拼接
        displacementMap.setWrap(false);

        System.out.println(displacementMap.isWrap());
        Text text = new Text();
        text.setText("没吊用 不如自已算 改变像素点");
        text.setFill(Color.web("0x3b596d"));
        text.setFont(Font.font(null, FontWeight.BOLD, 38));
        text.setEffect(displacementMap);
        text.setPickOnBounds(true);
        text.setStroke(Color.GREEN);
        text.setStrokeWidth(2);

        text.setTranslateX(100);

        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("setOnMouseClicked");
            }
        });

        root.getChildren().add(text);
        Scene scene = new Scene(root);
        primaryStage.setTitle("DisplacementMapDemo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo.games.three;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

public class OneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        //是否支持3D
        System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));

        Button button = new Button("one");
        button.setTranslateZ(0);
        Button button2 = new Button("two");
        button2.setTranslateZ(100);
        Button button3 = new Button("three");
        button3.setLayoutX(100);

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(root.prefWidth(-1));
                System.out.println(root.prefHeight(-1));
            }
        });

        root.getChildren().addAll(button, button2, button3);
        /*
        * DISABLE 指定禁用深度测试
        * ENABLE 指定启用深度测试
        * INHERIT 指定深度测试状态是从父代继承的
        * 开启了这个 同一个XY坐标的组件 无法点击  不同Z可以显示出来
        * */
        root.setDepthTest(DepthTest.ENABLE);
//        root.setBackground(Background.EMPTY);
        //使用3D效果
        Scene scene = new Scene(root, 800, 800, true);
        //ParallelCamera  PerspectiveCamera 相机
        scene.setCamera(new PerspectiveCamera());
        primaryStage.setTitle("3D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

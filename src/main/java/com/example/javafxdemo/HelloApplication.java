package com.example.javafxdemo;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/*
 * Platform.exit() 导致JavaFX应用程序终止
 * Platform.runLater();UI线程 和默认调用start(Stage stage)方法的线程一样
 *                       不要执行大的任务
 *
 * 设置这个关闭窗口时不会结束程序 要使用Platform.exit() 才会结束程序
 * Platform.setImplicitExit(false);
 *
 * 是否支持一些特性 比如是否支持3D ...
 * Platform.isSupported(ConditionalFeature.SCENE3D);
 * */
public class HelloApplication extends Application {

    @Override
    public void init() {
        System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //加载css文件
        scene.getStylesheets().add(HelloApplication.class.getResource("hello-view.css").toExternalForm());
        stage.setTitle("Hello!");

        VBox vbox = new VBox();
        //子组件数量改变整事件
        vbox.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {

            }
        });

        //在屏幕中的位置 默认居中
//        stage.setX(300);
        stage.setScene(scene);
        //StageStyle.DECORATED, StageStyle.UNDECORATED, StageStyle.TRANSPARENT,StageStyle.UTILITY
        stage.initStyle(StageStyle.DECORATED);
        System.out.println(Thread.currentThread());
        //触发事什
        stage.setOnCloseRequest(System.out::println);
        stage.focusedProperty().addListener((observable, oldValue, newValue) -> System.out.println(observable));
        System.out.println(stage.getFullScreenExitHint());
        //事件过滤  MouseEvent KeyEvent
        stage.addEventFilter(KeyEvent.KEY_PRESSED, event -> System.out.println("addEventFilter"));
        //添加事件
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> System.out.println("addEventHandler:" + event.getCode()));
        //高度变化监听
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(oldValue + " " + newValue);
            }
        });
        /*
        stage.resizableProperty()
        *
        * */
        //X位置变化监听
        stage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });

        //根据ID查找子组件
        System.out.println("id=" + scene.lookup("#welcomeText"));
        HelloController controller = fxmlLoader.getController();
        System.out.println(controller);

        stage.setAlwaysOnTop(false);//永远在顶层
        stage.setFullScreen(false);//设置全屏
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("favicon.ico")));
        stage.setResizable(true);//固定大小
//        stage.setMaximized(true);最大化窗口
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
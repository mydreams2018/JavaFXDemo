package com.example.javafxdemo.html;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.concurrent.Worker.State;

public class WebViewDemo extends Application {

    /*
     * WebView 是用于管理 WebEngine 并显示其内容的节点
     *  关联的 WebEngine 在施工时自动创建，之后无法更改
     *  WebView 处理鼠标和一些键盘事件 并自动管理滚动 因此无需将其放入 ScrollPane  自适应页面
     *
     *  WebEngine 类提供了两种方法来将内容装入到 WebEngine 对象中
     *  1. 从任意 URL 使用 load(java.lang.String) 方法 此方法使用 java.net 包进行网络访问和协议处理
     *  2. 从使用 loadContent(java.lang.String， java.lang.String) 和 loadContent(java.lang.String) 方法的内存中字符串
     *
     *  装入总是发生在后台线程上  在调度后台作业后立即启动装入返回的方法
     *   要跟踪进度和/或取消作业 请使用 getLoadWorker() 方法提供的工作程序实例
     * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();

        WebView webView = new WebView();

        WebEngine engine = webView.getEngine();
        engine.getLoadWorker().stateProperty().addListener(
                (ov, oldState, newState) -> {
                    if (newState == State.SUCCEEDED) {
                        primaryStage.setTitle(engine.getLocation());
//                        Document document = engine.getDocument();
//                        Node body = document.getElementsByTagName("body").item(0);
                        System.out.println(engine.executeScript("window.innerWidth"));
                    }
                });

        webView.prefWidthProperty().bind(root.widthProperty());
        //页面的整体缩放
        webView.setZoom(1);
        engine.load("https://developer.mozilla.org/en-US/docs/Web/API/DocumentPictureInPictureEvent/window");
        root.getChildren().add(webView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("HTMLEditor Demo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();


        WebHistory history = engine.getHistory();
        //浏览记录
        System.out.println(history);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

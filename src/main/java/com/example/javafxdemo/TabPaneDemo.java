package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TabPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        TabPane tabPane = new TabPane();
        tabPane.setMinHeight(300);
        //面板的方向
        tabPane.setSide(Side.TOP);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setBackground(Background.fill(Paint.valueOf("green")));
        hBox.getChildren().addAll(new Button("one"), new Button("two"), new Button("three"));

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(10);
        hBox1.setBackground(Background.fill(Paint.valueOf("yellow")));
        hBox1.getChildren().addAll(new Button("one"), new Button("two"), new Button("three"));

        Tab tab = new Tab();
        tab.setText("new tab");
        tab.setClosable(false);
        tab.setContent(hBox);
        ImageView imageView = new ImageView("https://www.kungreat.cn/favicon.ico");
        imageView.setFitHeight(18);
        imageView.setFitWidth(18);
        tab.setGraphic(imageView);
        Tab tab2 = new Tab();
        tab2.setText("new tab2");
        tab2.setClosable(false);
        tab2.setContent(hBox1);

        tabPane.getTabs().addAll(tab, tab2);
        //默认选中子索引
        tabPane.getSelectionModel().clearAndSelect(0);
        //不生效 初始化好以后是全屏的
        BorderPane.setAlignment(tabPane, Pos.TOP_CENTER);
        root.setTop(tabPane);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();


        primaryStage.setOnCloseRequest(event -> {
            System.out.println(root.getWidth());
            System.out.println(tabPane.getWidth());
            System.out.println(hBox.getWidth());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StageLevel extends Application {

    /*
    * Stage 之间层级的关联关系
    * */

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("primaryStage");
        primaryStage.show();

        Stage one = new Stage();
        one.setTitle("one");

        Stage two = new Stage();
        //在此窗口前边显示的窗口 无法获得焦点 除非此窗口关闭
        //two.initModality(Modality.APPLICATION_MODAL);
        //此窗口存在时无法让one室口获得焦点 除非此窗口关闭
        two.initOwner(one);
        two.initModality(Modality.WINDOW_MODAL);
        two.setTitle("two");

        Stage three = new Stage();
        three.setTitle("three");

        one.show();
        two.show();
        three.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

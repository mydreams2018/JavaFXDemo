package com.example.javafxdemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SpinnerDemo extends Application {

    /*
    *  注意 有些情况下需要使用 此种方法更改对象的值才能刷新组件
    *  SpinnerValueFactory.setValue(Object)方法  触发setConverter数据转换
    *   SpinnerValueFactory.IntegerSpinnerValueFactory
        SpinnerValueFactory.DoubleSpinnerValueFactory
        SpinnerValueFactory.ListSpinnerValueFactory
    *   可以查看官方源代码实现
     * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox();

        ObservableList<String> strings = FXCollections.observableArrayList("one", "two", "three");
        Spinner<String> spinnerStr = new Spinner<>(strings);
        spinnerStr.setEditable(false);
        //改变默认的样式
        spinnerStr.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL);

        Spinner<Integer> spinner = new Spinner<>(0, 10, 5, 1);
        spinner.setEditable(false);
        hbox.getChildren().addAll(spinner, spinnerStr);
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

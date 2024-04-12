package com.example.javafxdemo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        TextField tf = new TextField();
        tf.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //选中文体数据事件 可以用在制作富文本编辑器中
                System.out.println(newValue);
            }
        });
        root.getChildren().add(tf);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setTitle("TextLable Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

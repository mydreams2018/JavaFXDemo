package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;

public class ComboBoxDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox();

        ChoiceBoxDemo.User user = new ChoiceBoxDemo.User("two", 19, "woman");

        ComboBox<ChoiceBoxDemo.User> userComboBox = new ComboBox<>();
        userComboBox.getItems().addAll(new ChoiceBoxDemo.User("one", 18, "man"),
                user);
        //设置显示的数量
        userComboBox.setVisibleRowCount(userComboBox.getItems().size());
        //可编辑 数据容易误改
        userComboBox.setEditable(false);
        //默认选中的行
        userComboBox.getSelectionModel().select(0);
        userComboBox.setPromptText("没选中时提示语");
        userComboBox.setConverter(new StringConverter<ChoiceBoxDemo.User>() {

            @Override
            public String toString(ChoiceBoxDemo.User object) {
                return object.getName() + ": " + object.getAge();
            }
            //编辑后的数据 同一个对象修改
            @Override
            public ChoiceBoxDemo.User fromString(String string) {
                user.setAge(99);
                return user;
            }
        });

        hBox.getChildren().add(userComboBox);
        Scene scene = new Scene(hBox);
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

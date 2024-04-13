package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ChoiceBoxDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox();
        //用的是泛型的toString()显示
        ChoiceBox<User> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(new User("one",18,"man"), new User("two",19,"woman"));
        choiceBox.getSelectionModel().select(1);
        //选中的组件
        System.out.println(choiceBox.getValue());

        hBox.getChildren().addAll(choiceBox);
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


    public static final class User {
        private String name;
        private int age;
        private String gender;

        public User(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}

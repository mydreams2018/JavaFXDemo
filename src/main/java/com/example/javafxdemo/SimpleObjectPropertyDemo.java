package com.example.javafxdemo;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SimpleObjectPropertyDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Button button = new Button("Button");
        SimpleObject simpleObject = new SimpleObject("kun", 15, 18);
        simpleObject.namePropertyProperty().addListener((observable, oldValue, newValue) ->
                System.out.println("oldValue: " + oldValue + " newValue: " + newValue));
        button.setOnAction(event -> simpleObject.setNameProperty("Hello World"));
        root.getChildren().add(button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static final class SimpleObject {

        private String name;
        private int age;
        private double money;

        private final SimpleStringProperty nameProperty;
        private final SimpleIntegerProperty ageProperty;
        private final SimpleDoubleProperty moneyProperty;

        public SimpleObject(String name, int age, double money) {
            this.name = name;
            this.age = age;
            this.money = money;
            this.nameProperty = new SimpleStringProperty(name);
            this.ageProperty = new SimpleIntegerProperty(age);
            this.moneyProperty = new SimpleDoubleProperty(money);
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAgeProperty() {
            return ageProperty.get();
        }

        public SimpleIntegerProperty agePropertyProperty() {
            return ageProperty;
        }

        public double getMoneyProperty() {
            return moneyProperty.get();
        }

        public SimpleDoubleProperty moneyPropertyProperty() {
            return moneyProperty;
        }

        public String getNameProperty() {
            return nameProperty.get();
        }

        public SimpleStringProperty namePropertyProperty() {
            return nameProperty;
        }

        /*
         * 事件通知的设置方法
         * */
        public void setNameProperty(String name) {
            this.nameProperty.set(name);
        }

        public void setAgeProperty(int age) {
            this.ageProperty.set(age);
        }

        public void setMoneyProperty(double money) {
            this.moneyProperty.set(money);
        }

    }

}

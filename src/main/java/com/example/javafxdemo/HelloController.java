package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        welcomeText.setOpacity(0.6);
    }

    //当其关联文档的内容已完全装入时 该方法将在实施控制器上调用一次  ResourceBundle 可以用做国际化
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("当其关联文档的内容已完全装入时 该方法将在实施控制器上调用一次");
    }
}
package com.example.javafxdemo.html;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HTMLEditorDemo extends Application {

    /*
    * html 富文本编辑器
    * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();

        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.prefWidthProperty().bind(root.widthProperty());

        root.getChildren().add(htmlEditor);
        Scene scene = new Scene(root);
        primaryStage.setTitle("HTMLEditor Demo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

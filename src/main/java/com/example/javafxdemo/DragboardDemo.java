package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.List;

public class DragboardDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResourceAsStream("srcIn.jpg")));
        imageView.minWidth(300);
        imageView.minHeight(300);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        //不要自适应 最小高宽
        imageView.setPreserveRatio(false);
        imageView.setSmooth(true);
        HBox hBox = new HBox();
        Button button = new Button("button");
        button.setOnAction(event -> {
            System.out.println(imageView.prefHeight(-1));
            System.out.println(imageView.prefWidth(-1));
            System.out.println(hBox.getWidth());
            System.out.println(hBox.getHeight());
        });

        hBox.setBackground(Background.fill(Color.GREENYELLOW));
        hBox.getChildren().addAll(imageView, button);

        hBox.setOnDragEntered(event -> System.out.println("drag entered"));
        hBox.setOnDragExited(event -> System.out.println("drag exited"));

        hBox.setOnDragOver(event -> {
            //必需要设置这个 后边的setOnDragDropped 才能生效
            event.acceptTransferModes(event.getTransferMode());
        });

        hBox.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            if (dragboard.hasFiles()) {
                List<File> files = dragboard.getFiles();
                for (File file : files) {
                    if (file.isFile() && file.exists() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".png"))) {
                        Image image = new Image(file.toURI().toString());
                        //图像没有异常时
                        if (image.getException() == null) {
                            imageView.setImage(image);
                        }
                        break;
                    }
                }
            } else if (dragboard.hasImage()) {
                Image image = dragboard.getImage();
                if (image.getException() == null) {
                    imageView.setImage(image);
                }
            } else if (dragboard.hasUrl()) {
                Image image = new Image(dragboard.getUrl());
                if (image.getException() == null) {
                    imageView.setImage(image);
                }
            } else if (dragboard.hasString()) {

            }
        });

        AnchorPane.setLeftAnchor(hBox, 0.0);
        AnchorPane.setTopAnchor(hBox, 0.0);
        root.getChildren().add(hBox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Dragboard Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

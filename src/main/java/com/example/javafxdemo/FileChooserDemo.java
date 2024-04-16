package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class FileChooserDemo extends Application {

    /*
    * DirectoryChooser 目录选择器
    * */

    @Override
    public void start(Stage stage) throws Exception {
        HBox hbox = new HBox(10);

        Button button = new Button("Single File");
        Button button2 = new Button("Multiple Choice File");
        Button button3 = new Button("Save File");
        hbox.getChildren().addAll(button, button2, button3);

        button.setOnAction(event -> {
            /*
             * 文件选择器可用于调用文件打开对话框以选择单个文件 (showOpenDialog)
             * 文件打开对话框用于选择多个文件 (showOpenMultipleDialog)
             * 和文件保存对话框 (showSaveDialog)
             * */
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                    new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                System.out.println(selectedFile);
            }
        });

        button2.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                    new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            List<File> selectedFiles = fileChooser.showOpenMultipleDialog(stage);
            if (selectedFiles != null && !selectedFiles.isEmpty()) {
                System.out.println(selectedFiles);
            }
        });

        button3.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");
            //默认的文件名称
            fileChooser.setInitialFileName("badeDemo.txt");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                    new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                //确定后的文件名称 可能不存在需要新建
                System.out.println(file);
            }
        });

        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setAlwaysOnTop(false);//永远在顶层
        stage.setFullScreen(false);//设置全屏
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("favicon.ico")));
        stage.setResizable(true);//固定大小
        stage.setMaximized(false);//最大化窗口
        stage.setTitle("FileChooserDemo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

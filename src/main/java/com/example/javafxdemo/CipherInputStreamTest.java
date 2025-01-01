package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class CipherInputStreamTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Cipher cipher = CipherUtils.DEFAULTA.getDecryptNoIV("AES");
        ImageView iv2 = getImageView(cipher);
        Group root = new Group();
        root.getChildren().add(iv2);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setAlwaysOnTop(false);//永远在顶层
        stage.setFullScreen(false);//设置全屏
        stage.getIcons().add(new Image(getClass().getResourceAsStream("favicon.ico")));
        stage.setResizable(true);//固定大小
        stage.setMaximized(false);//最大化窗口
        stage.setTitle("ImageDemo");
        stage.show();
    }

    private static ImageView getImageView(Cipher initCipher) throws Exception {
        InputStream inputStream = new FileInputStream("C:\\Users\\mydre\\IdeaProjects\\knight\\src\\main\\resources\\animation\\fire1\\attackRight\\Knight_attack4.png");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(initCipher.doFinal(inputStream.readAllBytes()));
        Image image = new Image(byteArrayInputStream);
        return new ImageView(image);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

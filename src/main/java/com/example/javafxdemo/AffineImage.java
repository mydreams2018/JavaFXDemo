package com.example.javafxdemo;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/*
* 仿射转换工具类
* */
public class AffineImage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        root.setAutoSizeChildren(false);
        File fileIn = new File("E:\\game\\pixel-art-characters-for-platformer-games\\PNG\\Knight\\Attack_Extra\\");
        File fileOut = new File("C:\\Users\\kungr\\Documents\\affine\\");
        ImageView imageView = new ImageView();
        root.getChildren().add(imageView);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setTitle("Group Demo");
        primaryStage.setOnShown(event -> {
            Affine affine = new Affine(-1, 0, 0, 0, 1, 0);
            imageView.getTransforms().add(affine);
            File[] listFilesIn = fileIn.listFiles();
            for (File file : listFilesIn) {
                imageView.setImage(new Image(file.toURI().toString()));
                SnapshotParameters CANVAS_SNAPSHOT_PARAMETERS = new SnapshotParameters();
                CANVAS_SNAPSHOT_PARAMETERS.setFill(Color.color(0, 0, 0, 0));
                WritableImage writableImage = imageView.snapshot(CANVAS_SNAPSHOT_PARAMETERS, null);
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
                try {
                    ImageIO.write(bufferedImage, "png", new File(fileOut, file.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        primaryStage.show();

    }
}

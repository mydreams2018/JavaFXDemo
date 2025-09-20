package com.example.javafxdemo;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/*
 * 仿射转换工具类
 * */
public class GroupImageSave extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final SnapshotParameters CANVAS_SNAPSHOT_PARAMETERS = new SnapshotParameters();
        CANVAS_SNAPSHOT_PARAMETERS.setFill(Color.color(0, 0, 0, 0));
        Group root = new Group();
        root.setAutoSizeChildren(false);
        ImageView imageViewBg = new ImageView(new File("E:\\mirImageMerge\\uiView\\54465.png").toURI().toString());
        ImageView imageViewOne = new ImageView(new File("E:\\mirImageMerge\\uiView\\588.png").toURI().toString());
        imageViewOne.setLayoutY(30);
        imageViewOne.setLayoutX(60);
        ImageView imageViewTwo = new ImageView(new File("E:\\mirImageMerge\\uiView\\588.png").toURI().toString());
        imageViewTwo.setLayoutY(30);
        imageViewTwo.setLayoutX(240);

        root.getChildren().addAll(imageViewBg, imageViewOne, imageViewTwo);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("GroupImageSave Demo");
        imageViewBg.setOnMouseClicked(event -> {
            WritableImage writableImage = root.snapshot(CANVAS_SNAPSHOT_PARAMETERS, null);
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", new File("C:\\Users\\mydre\\Downloads\\54465.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        primaryStage.show();
    }
}

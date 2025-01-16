package com.example.javafxdemo.mir;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RoleTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        RolePlayImages rolePlayImages = new RolePlayImages(RoleTest.class.getResource("role"),"01");
        Group root = new Group();
        Path path = new Path();
        for (int i = 0; i < 10; i++) {
            MoveTo moveTo = new MoveTo(0, i * 32);
            HLineTo hLineTo = new HLineTo(480);
            path.getElements().add(moveTo);
            path.getElements().add(hLineTo);
        }
        for (int i = 0; i < 10; i++) {
            MoveTo moveTo = new MoveTo(i * 48, 0);
            VLineTo hLineTo = new VLineTo(320);
            path.getElements().add(moveTo);
            path.getElements().add(hLineTo);
        }
        path.getElements().add(new ClosePath());
        path.setFillRule(FillRule.NON_ZERO);
        path.setStroke(Color.RED);
        path.setStrokeWidth(1);

        Button startRoleImage = new Button("start");
        startRoleImage.setLayoutY(64);
        ImageView imageView = new ImageView();
        imageView.setLayoutX(48);
        imageView.setLayoutY(32);
        imageView.setImage(rolePlayImages.getAllImagesCache().getFirst());
        Timeline timeline = new Timeline();
        for (int i = 0; i < rolePlayImages.getAllImagesCache().size(); i++) {
            KeyFrame keyFrame = new KeyFrame(Duration.millis(i * 100), String.valueOf(i), event -> {
                KeyFrame source = (KeyFrame) event.getSource();
                int indexImage = Integer.parseInt(source.getName());
                imageView.setImage(rolePlayImages.getAllImagesCache().get(indexImage));
                imageView.setLayoutX(48 + rolePlayImages.getAllFilesCache().get(indexImage).offsetX());
                imageView.setLayoutY(32 + rolePlayImages.getAllFilesCache().get(indexImage).offsetY());
                System.out.println(indexImage);
            });
            timeline.getKeyFrames().add(keyFrame);
        }
        startRoleImage.setOnMouseClicked(event -> timeline.play());
        root.getChildren().addAll(path, startRoleImage, imageView);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(480);
        primaryStage.setHeight(320);
        primaryStage.setResizable(false);
        primaryStage.setTitle("RoleTest");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

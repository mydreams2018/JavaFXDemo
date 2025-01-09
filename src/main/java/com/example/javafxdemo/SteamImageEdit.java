package com.example.javafxdemo;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SteamImageEdit extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        int autoWidth = 1280;
        int autoHeight = 720;

        Group root = new Group();

//        Image image0 = new Image(SteamImageEdit.class.getResourceAsStream("Background.png"));
//        ImageView imageView0 = new ImageView(image0);
//        imageView0.setFitWidth(autoWidth);
//        imageView0.setFitHeight(autoHeight);
//
//        Image image1 = new Image(SteamImageEdit.class.getResourceAsStream("characters.png"));
//        ImageView imageView1 = new ImageView(image1);
//        imageView1.setFitWidth(204);
//        imageView1.setFitHeight(112);
//        imageView1.setLayoutX((autoWidth - 408) / 2);
//        imageView1.setLayoutY((autoHeight - 224) / 2);

        Image image2 = new Image(SteamImageEdit.class.getResourceAsStream("platform.png"));
        ImageView imageView2 = new ImageView(image2);
//        imageView2.setFitWidth(158);
//        imageView2.setFitHeight(29);
//        int lax = (autoWidth - 316) / 2;
//        int lay = (int) (imageView1.getLayoutY() + 212);
//        imageView2.setLayoutX(lax);
//        imageView2.setLayoutY(lay);


//        VBox vBox = new VBox();
//        vBox.setMinWidth(autoWidth);
//        vBox.setMinHeight(autoHeight);
//        vBox.setBackground(Background.fill(Color.BLACK));
//        vBox.setOpacity(0.6);

//
//        imageView2.setLayoutX(imageView1.getLayoutX() + 12);
//        imageView2.setLayoutY(imageView1.getLayoutY() + 56);

        Label label = new Label("SuperCowBoy");
        label.setPrefWidth(autoWidth);
        label.setPrefHeight(autoHeight);
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font(64));
        label.setLayoutY(20);

        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(4);
        innerShadow.setOffsetY(4);
        innerShadow.setChoke(0.2);
        innerShadow.setBlurType(BlurType.GAUSSIAN);
        innerShadow.setColor(Color.color(0.4, 0.5, 0.5));
        label.setEffect(innerShadow);


        root.getChildren().addAll(label);
        Scene scene = new Scene(root,autoWidth,autoHeight);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("SteamImageEdit");
//        primaryStage.setOnShown(event -> {
//            SnapshotParameters snapshotParameters = new SnapshotParameters();
//            snapshotParameters.setFill(Color.color(0, 0, 0, 0));
//            WritableImage writableImage = root.snapshot(snapshotParameters, null);
//            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
//            try {
//                ImageIO.write(bufferedImage, "png", new File("C:\\Users\\mydre\\Pictures\\库徽标.png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

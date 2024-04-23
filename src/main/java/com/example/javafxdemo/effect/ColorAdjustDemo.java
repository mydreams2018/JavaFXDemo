package com.example.javafxdemo.effect;

import com.example.javafxdemo.HelloApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ColorAdjustDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        /*
        * HSB模式调色 色相 饱和度 明度
        * */
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(0.1);
        colorAdjust.setHue(-0.05);
        colorAdjust.setBrightness(0.1);
        colorAdjust.setSaturation(0.2);

        Image image = new Image(HelloApplication.class.getResource("R-C.jpg").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setEffect(colorAdjust);

        root.getChildren().add(imageView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("ColorAdjustDemo");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

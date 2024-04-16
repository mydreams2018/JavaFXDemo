package com.example.javafxdemo;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class WritableImageDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        WritableImage image = new WritableImage(100, 100);
        //是否后台加载
        System.out.println(image.isBackgroundLoading());
        //是否自适应
        System.out.println(image.isPreserveRatio());
        //是否使用更好的质量过滤算法或更快速的过滤算法 以适合 fitWidth 和 FitHeight
        System.out.println(image.isSmooth());

//        image.getPixelReader(); read
        PixelWriter pixelWriter = image.getPixelWriter();
        System.out.println(pixelWriter.getPixelFormat().getType());

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                pixelWriter.setColor(i, j, Color.GREEN);
            }
        }

        //保存图片数据
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        System.out.println(bufferedImage);
        //会自动创建文件 ImageIO   formatName 包含格式非正式名称的字符串
        System.out.println(ImageIO.write(bufferedImage, "png", new File("C:\\Users\\mydre\\Desktop\\test.png")));

        HBox root = new HBox();
        root.getChildren().add(new ImageView(image));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("WritableImage Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

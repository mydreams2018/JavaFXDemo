package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class PixelReaderDemo extends Application {

    /*
     * 像素读取  ARGB=0 就是全透明
     * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Image image = new Image(getClass().getResourceAsStream("720w.png"));
        //此接口定义从图像或包含像素的其他表面检索像素数据的方法
        PixelReader pixelReader = image.getPixelReader();

        System.out.println(image.getPixelReader().getPixelFormat().getType());

        int argb = pixelReader.getArgb(3, 0);
        System.out.println(Arrays.toString(CutoverBytes.intToByteArray(argb)));

        Color color = pixelReader.getColor(10, 10);
        System.out.println(color.getOpacity() * 255 + " " + color.getRed() * 255 + " " + color.getGreen() * 255 + " " + color.getBlue() * 255);
        System.out.println(color);

        WritablePixelFormat<ByteBuffer> bgraInstance = PixelFormat.getByteBgraInstance();
        //如果有小数点 舍掉
        int readWidth = (int) image.getWidth();
        int readHeight = (int) image.getHeight();
        byte[] bts = new byte[(readWidth * 4 * readHeight) + 4];
        /*  读取矩形块的数据
         * x 起始点
         * y 起始点
         * w 要读取数据的宽度
         * h 要读取数据的高度
         * offest 偏移到 bts 缓冲区以存储第一个像素数据
         * scanlineStride 一行数据的长度 要注意单位是 int 还是 byte
         * */
        pixelReader.getPixels(0, 0, readWidth, readHeight, bgraInstance, bts, 4, readWidth * 4);

        for (int i = 0; i < bts.length; i += 4) {
            byte B = bts[i];
            byte G = bts[i + 1];
            byte R = bts[i + 2];
            byte A = bts[i + 3];
            System.out.println(B + " " + G + " " + R + " " + A);
            if (i == 32) {
                break;
            }
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

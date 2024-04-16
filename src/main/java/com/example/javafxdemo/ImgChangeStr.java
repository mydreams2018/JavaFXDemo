package com.example.javafxdemo;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ImgChangeStr {

    public static void main(String[] args) throws IOException {
        new ImgChangeStr().writeTxt();
    }

    public void writeTxt() throws IOException {
        Image image = new Image(getClass().getResourceAsStream("R-C.jpg"), 300,
                300, true, true);
        PixelReader pixelReader = image.getPixelReader();
        StringBuffer sb = new StringBuffer();
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                sb.append(readTxt(pixelReader.getArgb(x, y)));
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(Files.writeString(Paths.get("C:\\Users\\mydre\\Documents\\imgStr.txt"),
                sb, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING));

    }

    public String readTxt(int argb) {
        byte b = CutoverBytes.intToByteArray(argb)[1];
        if (b <= 30) {
            return "#";
        } else if (b <= 60) {
            return "&";
        } else if (b <= 90) {
            return "*";
        } else if (b <= 120) {
            return ".";
        } else {
            return " ";
        }
    }
}

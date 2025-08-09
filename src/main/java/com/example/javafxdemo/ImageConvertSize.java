package com.example.javafxdemo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConvertSize {

    public static void main(String[] args) throws IOException {
        String pngName = "122.png";
        // 输入和输出文件路径
        String inputImagePath = "E:\\mirImageMerge\\dnItem\\" + pngName;
        String outputImagePath = "F:\\mir\\dnItem\\" + pngName;
        // 缩放比例 (0.0 - 1.0 缩小，>1.0 放大)
        double scale = 0.5;
        // 调用缩放方法
        scaleAndSaveImage(inputImagePath, outputImagePath, scale);
        System.out.println("图片缩放并保存成功!");
    }


    /**
     * 缩放图片并保存
     *
     * @param inputPath  输入图片路径
     * @param outputPath 输出图片路径
     * @param scale      缩放比例
     * @throws IOException 如果读写文件失败
     */
    public static void scaleAndSaveImage(String inputPath, String outputPath, double scale) throws IOException {
        // 1. 读取原始图片
        BufferedImage originalImage = ImageIO.read(new File(inputPath));
        // 2. 计算新尺寸
        int newWidth = (int) (originalImage.getWidth() * scale);
        int newHeight = (int) (originalImage.getHeight() * scale);
        // 3. 创建缩放后的图片
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        // 4. 缩放并绘制图像
        Graphics2D g2d = scaledImage.createGraphics();
        // 设置渲染质量
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC); // 速度最慢，质量最高
        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        // 6. 保存缩放后的图片
        ImageIO.write(scaledImage, "png", new File(outputPath));
    }
}

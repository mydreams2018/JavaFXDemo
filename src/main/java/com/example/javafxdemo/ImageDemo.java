package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ImageDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // load the image
        Image image = new Image(getClass().getResourceAsStream("720w.png"));

        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        //根据需要调整源映像大小的宽度
        iv2.setFitWidth(100);
        //是否保留源图像的长宽比以适合边界框内的图像
        iv2.setPreserveRatio(true);
        //指示在变换或缩放源映像时 是否使用更好的质量过滤算法或更快速的过滤算法 以适合 fitWidth 和 FitHeight
        iv2.setSmooth(true);
        //是否使用高速缓存位图  会占用内存空间
        iv2.setCache(true);

        //入参时的宽度
        System.out.println(image.getRequestedWidth());
        //实际的宽度
        System.out.println(image.getWidth());
        //入参时的高度
        System.out.println(image.getRequestedHeight());
        //实际的高度
        System.out.println(image.getHeight());

        ImageView iv3 = new ImageView();
        iv3.setImage(image);
        Rectangle viewportRect = new Rectangle(image.getWidth(), image.getHeight());
        //矩形圆角 透明区域
        viewportRect.setArcHeight(20);
        viewportRect.setArcWidth(20);
//        指定用于定义此节点的剪切形状的节点
        iv3.setClip(viewportRect);

        /*
         * 图片有自适应时可以通过 以下方式获得 宽 高
         * */
        //设置的压缩高度
        System.out.println(iv2.getFitHeight());
        //返回节点的首选高度 以便在布局计算中使用
        System.out.println(iv2.prefHeight(iv2.getFitWidth()));
        //设置的压缩宽度
        System.out.println(iv2.getFitWidth());
        //返回节点的首选宽度 以便在布局计算中使用
        System.out.println(iv2.prefWidth(iv2.getFitHeight()));


        Group root = new Group();
        HBox box = new HBox();
        box.getChildren().addAll(iv2, iv3);
        root.getChildren().add(box);

        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
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

    public static void main(String[] args) {
        launch(args);
    }
}

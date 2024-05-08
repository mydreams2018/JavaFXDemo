package com.example.javafxdemo.games;

import com.example.javafxdemo.HelloApplication;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class CanvasDemo extends Application {
    /*
     * 画布是可以使用由 GraphicsContext 提供的一组图形命令绘制的图像
     * 画布节点构造为宽度和高度 用于指定绘制画布绘制命令的图像的大小  所有绘制操作都将剪切到该图像的边界
     *  by the save() and restore()
     * 画布仅包含一个 GraphicsContext 并且仅包含一个缓冲区
     * 如果它未连接到任何场景 那么它可以通过任何线程进行修改
     * 一旦将 Canvas 节点连接到场景 就必须在 JavaFX 应用程序线程上修改它
     *
     * GraphicalContext 还管理可以随时保存或恢复的状态对象的堆栈
     *
     * */

    final Canvas canvas = new Canvas(800, 700);
    final GraphicsContext gc = canvas.getGraphicsContext2D();
    SnapshotParameters snapshotParameters = new SnapshotParameters();
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        snapshotParameters.setFill(Color.GREEN);

        Image image = new Image(HelloApplication.class.getResourceAsStream("720w.png"));
        ImageView imageView = new ImageView(image);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.drawImage(imageView.snapshot(snapshotParameters, null), 101, 0);
                System.out.println("ddddd");
            }
        };

        //类似透明度
        FadeTransition ft = new FadeTransition(Duration.millis(300), imageView);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.setAutoReverse(true);


        HBox hbox = new HBox();
        root.setBackground(Background.fill(Color.GREEN));
        hbox.prefWidthProperty().bind(primaryStage.widthProperty());
        hbox.getChildren().add(imageView);
        root.setCenter(canvas);
        root.setTop(hbox);
        primaryStage.setTitle("游戏画布");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
        animationTimer.start();
        ft.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

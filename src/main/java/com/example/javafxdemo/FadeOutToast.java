package com.example.javafxdemo;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeOutToast extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 主布局
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #f0f0f0;");
        // 创建一个按钮来触发提示
        Button showButton = new Button("显示提示");
        showButton.setOnAction(e -> showToast(root, "这是一条渐渐消失的提示信息！"));
        // 将按钮放在中心
        root.getChildren().add(showButton);

        // 设置场景和舞台
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("渐隐提示信息示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * 显示一个渐隐的提示标签
     *
     * @param parent 父容器（用于添加和移除 Label）
     * @param message 提示文本
     */
    private void showToast(StackPane parent, String message) {
        // 创建提示标签
        Label toastLabel = new Label(message);
        toastLabel.setStyle("-fx-text-fill: green; -fx-font-size: 36px;");
        // 设置初始透明度为 0（不可见）
        toastLabel.setOpacity(0.0);
        // 添加到父容器（居中）
        parent.getChildren().add(toastLabel);
        StackPane.setAlignment(toastLabel, javafx.geometry.Pos.CENTER);

        SequentialTransition sequence = new SequentialTransition();
        // 淡入动画：从 0 到 1，持续 0.3 秒
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), toastLabel);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        PauseTransition pause = new PauseTransition(Duration.seconds(1.0));
        // 淡出动画：从 1 到 0，延迟 2 秒后开始，持续 0.5 秒
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), toastLabel);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        // 将三个动画按顺序加入序列
        sequence.getChildren().addAll(fadeIn, pause, fadeOut);
        // 动画结束时移除节点
        sequence.setOnFinished(event -> parent.getChildren().remove(toastLabel));
        // 开始播放合并后的动画序列
        sequence.playFromStart();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
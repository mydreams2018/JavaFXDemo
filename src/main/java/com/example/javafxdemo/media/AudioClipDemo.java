package com.example.javafxdemo.media;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class AudioClipDemo extends Application {
    /*
    * AudioClip 表示可以在最短等待时间内播放的音频片段
    *
    * balance 新值只会影响后续的播放 DoubleProperty   片段的相对左右音量级别 有效范围为-1.0到1.0 其中-1.0为左通道提供全音量
    *               同时静音右通道 0.0为两个通道提供全容量 1.0为右通道提供全体积 同时静音左通道
    * cycleCount 调用播放时将播放该剪辑的次数 IntegerProperty
    * pan DoubleProperty 平移值为0.0时正常播放片段 其中-1.0平移会将片段完全移动到左通道 1.0平移会将剪辑完全移动到右通道
    *                       与平衡不同 此设置混合两个通道因此两个通道都不会丢失数据
    * priority IntegerProperty 优先级 此值用于确定在超过允许的最大剪辑数时要删除哪些剪辑 优先级越低
    *                           剪辑就越有可能被停止并从它所占用的混合器通道中移除
    *                            有效范围为任意整数 没有任何约束 在更改之前所有剪辑的默认优先级为零
    *                               可以同时播放的声音的数量取决于实现 也可能取决于系统
    * rate DoubleProperty 播放片段的相对速率 有效范围为0.125（1/8速度）到8.0速度
    *                     超出此范围的值在内部被钳制 剪辑的正常播放为1.0
    * volume DoubleProperty 播放片段的相对音量级别 有效范围为0.0到1.0
    * play() 使用所有缺省参数播放 AudioClip
    * play(double volume) 使用指定的音量级别播放
    * play(double volume, double balance, double rate, double pan, int priority) 使用给定的参数播放
    * stop()
    * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        AudioClip plonkSound = new AudioClip("http://somehost/path/plonk.aiff");
        plonkSound.play();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("AudioClip Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

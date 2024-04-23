package com.example.javafxdemo.animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.WritableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
* 提供一组类以简化基于过渡的动画
* 它提供了一个简单的框架 用于将动画合并到内部时间线上 它还提供了高水平构造以构成多个动画的效果
    autoReverse 定义此动画是否在交替循环上反转方向
    currentRate 只读变量 用于指示正在播放动画的当前方向/速度
    currentTime 定义动画的播放头位置
    cycleCount 定义此动画中的周期数 定义此动画中的循环数 对于无限重复的动画 cycleCount可能是INDELIFY 但在其他情况下必须大于0
                                无法更改正在运行的动画的循环计数 如果正在运行的动画的cycleCount值发生了更改 则必须停止并重新启动动画以获取新值
    cycleDuration 只读变量 用于指示此动画的一个周期的持续时间  从时间 0 播放到动画结束的时间 ( 缺省情况下为 1.0 )
    delay 延迟动画的开始
    onFinished 此动画结束时要执行的操作
    rate 定义预期动画播放的方向/速度 反转费率的值将切换播放方向 0.0表示停止运行动画
                                速率1.0是正常播放 2.0是2倍正常播放 -1.0是向后播放
    status 动画的状态 STOPPED PAUSED RUNNING
    totalDuration 只读变量 用于指示此动画的总持续时间 包括重复

    jumpTo(String cuePoint) cuePoint - 提示点的名称  有两个预定义的提示点 "start" 和 " end" 定义为分别在此动画的末尾
    jumpTo(Duration time) 跳转到该动画中的给定位置 如果给定时间小于 Duration.ZERO  那么此方法将跳转到动画的开始 如果给定时间大于此动画的持续时间 那么此方法将跳至末尾
    pause() 暂停动画
    play() 按费率指示的方向从当前位置播放动画
    playFrom(String cuePoint)
    playFrom(Duration time)
    playFromStart()
    stop()
* */
public class AnimationDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        Button button = new Button("Button");
        Scale scale = new Scale(1,1,0,0);
        button.getTransforms().add(scale);

        Button button2 = new Button("play");
        //targetFramerate 关键帧
        final Timeline timeline = new Timeline(60);
        timeline.setCycleCount(4);
        timeline.setAutoReverse(true);

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(0), "init", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("每次完整的动画结束回调 setCycleCount次数 还要注意 setAutoReverse");
            }
        }, new KeyValue(button.translateXProperty(), button.translateXProperty().get(), Interpolator.EASE_BOTH),
                new KeyValue(button.opacityProperty(),1),
                new KeyValue(scale.xProperty(),1)));

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000), "end", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("每次完整的动画结束回调 setCycleCount次数 还要注意 setAutoReverse");
            }
        }, new KeyValue(button.translateXProperty(), 100, Interpolator.EASE_BOTH),
                new KeyValue(button.opacityProperty(),0),
                new KeyValue(scale.xProperty(),2)));


        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (timeline.getStatus() == Animation.Status.STOPPED || timeline.getStatus() == Animation.Status.PAUSED) {
                    timeline.play();
                    System.out.println(timeline.getTotalDuration());
                }
            }
        });

        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Timeline eventSource = (Timeline) event.getSource();
                ObservableList<KeyFrame> keyFrames = eventSource.getKeyFrames();
                keyFrames.forEach(new Consumer<KeyFrame>() {
                    @Override
                    public void accept(KeyFrame keyFrame) {
                        keyFrame.getValues().forEach(new Consumer<KeyValue>() {
                            @Override
                            public void accept(KeyValue keyValue) {
                                WritableValue<?> target = keyValue.getTarget();
                                System.out.println(target.getValue());
                            }
                        });
                    }
                });
            }
        });

        root.getChildren().addAll(button, button2);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();

        timeline.getCuePoints().forEach(new BiConsumer<String, Duration>() {
            @Override
            public void accept(String s, Duration duration) {
                System.out.println(s + " : " + duration);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

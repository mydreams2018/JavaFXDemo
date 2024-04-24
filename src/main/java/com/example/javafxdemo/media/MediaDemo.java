package com.example.javafxdemo.media;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaMarkerEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MediaDemo extends Application {

    /*
    * One Media object may be shared among multiple MediaPlayers.
      One MediaPlayer may be shared amoung multiple MediaViews.
    * */

    /*
     * Media
     * duration 源介质的持续时间秒
     * error 发生错误时 属性设置为MediaException值
     * height 源介质的高度 (以像素为单位)
     * onError 发生错误时调用事件处理程序
     * width 源介质的宽度 (以像素为单位)
     * getMarkers() 检索此介质实例上定义的标记 [可自定义标记] ObservableMap<String, Duration>
     * Media介质类表示介质资源 它是从源URI的字符串形式实例化的 可从媒体实例获取关于媒体的信息 例如持续时间 元数据 跟踪和视频分辨率
     *  介质信息是异步获取的 因此类在实例化后不一定立即可用  但是如果实例已与 MediaPlayer 相关联并且该播放器已转换为 MediaPlayer.Status.READY
     * 那么所有信息都应该可用 要在添加元数据或磁道时收到通知 可以分别向观察员注册 getMetadata()和 getTracks ( ) 返回的集合
     * */

    /*
     * MediaPlayer 类提供用于播放介质的控件 它与介质和 MediaView 类结合使用以显示和控制介质回放
     * 不包含任何可视元素 因此必须与 MediaView 类一起使用 以查看可能存在的任何视频跟踪
     *  audioSpectrumInterval 频谱更新之间的时间间隔(以秒为单位)
     *  audioSpectrumListener 用于音频频谱更新的侦听器
     *  audioSpectrumNumBands 音频频谱中的频带数
     *  audioSpectrumThreshold 灵敏度阈值(以分贝为标准)必须为非正
     *  autoPlay 是否应尽快开始播放
     *  balance 音频输出的平衡或左右设置
     *  bufferProgressTime 指示在不停滞 MediaPlayer的情况下可以播放多少介质的当前缓冲区位置
     *  currentCount 已完成的回放周期数
     *  currentRate 当前回放速率
     *  currentTime 当前介质回放时间
     *  cycleCount 媒体将被播放的次数
     *  cycleDuration 此播放器的 startTime 和 stopTime 之间的时间量
     *  error 如果发生错误 那么可观察属性设置为 MediaException
     *  mute 播放器音频是否静音
     *  onEndOfMedia 当播放器 currentTime 到达 stopTime时调用事件处理程序
     *  onError 发生错误时调用的事件处理程序
     *  onHalted 当状态更改为 " 已停止" 时会调用事件处理程序
     *  onMarker 当播放器 currentTime 到达介质标记时调用事件处理程序
     *  onPaused 状态更改为 PAUSED 时调用的事件处理程序
     *  onPlaying 状态更改为 PLAYING时调用的事件处理程序
     *  onReady 状态更改为 READY 时调用的事件处理程序
     *  onRepeat 当播放器 currentTime 到达 stopTime 时调用的事件处理程序将重复
     *  onStalled 当状态更改为 " 已停止" 时会调用事件处理程序
     *  onStopped 当状态更改为 " 已停止" 时会调用事件处理程序
     *  rate 播放片段的相对速率 有效范围为0.125（1/8速度）到8.0速度
     *                     超出此范围的值在内部被钳制 剪辑的正常播放为1.0
     *  startTime 介质应开始播放的时间偏移量 或在重复时重新启动
     *  status MediaPlayer 的当前状态
     *  stopTime 重复时介质应停止播放或重新启动的时间偏移量
     *  totalDuration 在完成之前允许播放的播放时间总量
     *  volume DoubleProperty 播放片段的相对音量级别 有效范围为0.0到1.0
     *
     * pause() 暂停
     * play() 开始播放媒体
     * seek(Duration seekTime) 将播放器转至新的回放时间
     * stop() 停止播放媒体
     * dispose() 释放与播放器相关联的所有资源
     * getAudioEqualizer() 类为媒体播放器提供音频均衡控制 它包含 EqualizerBand [每个频带的控制] 元素的 ObservableList
     * setAudioSpectrumListener(AudioSpectrumListener listener) 设置音频频谱的侦听器
     * */

    /*
    * MediaView 提供 MediaPlayer 正在播放的媒体视图的节点
    * fitHeight
    * fitWidth
    * mediaPlayer
    * onError
    * preserveRatio 在缩放时是否保留介质的长宽比(宽度 / 高度)以适合节点
    * smooth 如果设置为 true 那么在缩放此视频以适合在 fitWidth 和 FitHeight 提供的边界框内或变换时 将使用更好的质量过滤算法
    * viewport 只显示指定区域的图像 setViewport(Rectangle2D value)
    * X Y 定义 MediaView 原点的当前坐标
    * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Path path = Paths.get("D:\\出书\\book-mp4-1\\1.3线程创建方式.mp4");
        Media media = new Media(path.toUri().toString());
        media.getMarkers().put("10秒", Duration.seconds(10));
        media.getMarkers().put("20秒", Duration.seconds(20));
        /*
        media.getMetadata().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                //相关的描述信息
                System.out.println("getMetadata" + observable);
            }
        });
        media.getTracks().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("getTracks" + observable);
            }
        });
        */


        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.statusProperty().addListener(new ChangeListener<MediaPlayer.Status>() {
            @Override
            public void changed(ObservableValue<? extends MediaPlayer.Status> observable,
                                MediaPlayer.Status oldValue, MediaPlayer.Status newValue) {
                System.out.println("old" + oldValue + " new" + newValue);
                if (newValue == MediaPlayer.Status.READY) {
                    System.out.println(media.getDuration());
                }
            }
        });
        mediaPlayer.setOnMarker(new EventHandler<MediaMarkerEvent>() {
            @Override
            public void handle(MediaMarkerEvent event) {
                //Media 设置的标记事件
                System.out.println(event.getMarker());
            }
        });
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.fitWidthProperty().bind(root.widthProperty());
        mediaView.fitHeightProperty().bind(root.heightProperty());
        mediaView.setPreserveRatio(true);
        mediaView.setSmooth(true);

        root.getChildren().add(mediaView);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Media Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.javafxdemo.animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lombok.Getter;

import java.util.List;

/*
 * 添加动画 只需要添加一次 不能并发调用
 * */
@Getter
public class IntegrationAnimation {

    //空闲动画
    private Timeline idleTimeline;
    //功击动画
    private Timeline attackTimeline;
    private VariableAnimation attackVariableAnimation;
    //跑步重击
    private Timeline highAttackTimeline;
    private VariableAnimation highAttackVariableAnimation;
    //攀登动画
    private Timeline climbTimeline;
    //挂掉动画
    private Timeline deathTimeline;
    //受伤动画
    private Timeline hurtTimeline;
    //跳动画
    private Timeline jumpTimeline;
    //跑动画
    private Timeline runTimeline;
    //走动画
    private Timeline walkTimeline;
    private VariableAnimation walkVariableAnimation;
    //当前播放的动画类型标识
    private AnimationType animationType;

    private final ThreadLocal<OperationHistory> operationHistoryThreadLocal = new ThreadLocal<>();
    private final DurationControl moveDurationControl = new DurationControl(300);
    private final DurationControl attackDurationControl = new DurationControl(500);
    private final DurationControl highAttackDurationControl = new DurationControl(1000);

    /* 空闲动画
     * imageView 动画应用的图像
     * images 动画帧集合
     * durationMillis 动画的间隔时间
     * delayMillis 动画启动的延迟时间
     * */
    public void addIdleTimeline(ImageView imageView, List<Image> images, int durationMillis, int delayMillis) {
        if (this.idleTimeline == null) {
            this.idleTimeline = new Timeline();
            this.idleTimeline.setCycleCount(Animation.INDEFINITE);
            this.idleTimeline.setAutoReverse(false);
            imageView.setImage(images.getFirst());
            for (int i = 0; i < images.size(); i++) {
                KeyFrame keyFrame = new KeyFrame(Duration.millis(i * durationMillis), String.valueOf(i), event -> {
                    KeyFrame source = (KeyFrame) event.getSource();
                    int indexImage = Integer.parseInt(source.getName());
                    imageView.setImage(images.get(indexImage));
                });
                this.idleTimeline.getKeyFrames().add(keyFrame);
            }
            this.idleTimeline.setDelay(Duration.millis(delayMillis));
        }
    }

    /* 空闲动画
     * imageView 动画应用的图像
     * image 单个动画帧集合
     * imageSegmentation 单个图片的分割数量
     * durationMillis 动画的间隔时间
     * delayMillis 动画启动的延迟时间
     * */
    public void addIdleTimeline(ImageView imageView, Image image, int imageSegmentation, int durationMillis, int delayMillis) {
        if (this.idleTimeline == null) {
            this.idleTimeline = new Timeline();
            this.idleTimeline.setCycleCount(Animation.INDEFINITE);
            this.idleTimeline.setAutoReverse(false);
            final int singleWidth = (int) image.getWidth() / imageSegmentation;
            final int singleHeight = (int) image.getHeight();
            imageView.setImage(image);
            imageView.setViewport(new Rectangle2D(0, 0, singleWidth, singleHeight));
            for (int i = 0; i < imageSegmentation; i++) {
                KeyFrame keyFrame = new KeyFrame(Duration.millis(i * durationMillis), String.valueOf(i), event -> {
                    KeyFrame source = (KeyFrame) event.getSource();
                    int indexImage = Integer.parseInt(source.getName());
                    Rectangle2D rectangle2D = new Rectangle2D(indexImage * singleWidth, 0, singleWidth, singleHeight);
                    imageView.setViewport(rectangle2D);
                });
                this.idleTimeline.getKeyFrames().add(keyFrame);
            }
            this.idleTimeline.setDelay(Duration.millis(delayMillis));
        }
    }

    /* 步行动画
     * imageView 动画应用的图像
     * imagesRight 多个动画帧集合 右操作方向
     * imagesLeft 多个动画帧集合 左操作方向
     * durationMillis 动画的间隔时间
     * delayMillis 动画启动的延迟时间
     * moveDistance 每一步走的像素
     * operationHistoryDistance 左 <--> 右 转换时的一个间隔像素
     * */
    public void addWalkTimeline(ImageView imageView, List<Image> imagesRight, List<Image> imagesLeft, int durationMillis,
                                int delayMillis, int moveDistance, int operationHistoryDistance) {
        if (this.walkTimeline == null) {
            this.walkTimeline = new Timeline();
            this.walkTimeline.setCycleCount(1);
            this.walkTimeline.setAutoReverse(false);
            this.walkVariableAnimation = new VariableAnimation(imageView, imagesRight, imagesLeft, durationMillis, moveDistance,
                    this.operationHistoryThreadLocal, this.walkTimeline, operationHistoryDistance);
            this.walkTimeline.setDelay(Duration.millis(delayMillis));
        }
    }

    /* 功击动画
     * imageView 动画应用的图像
     * imagesRight 多个动画帧集合 右操作方向
     * imagesLeft 多个动画帧集合 左操作方向
     * durationMillis 动画的间隔时间
     * delayMillis 动画启动的延迟时间
     * moveDistance 每一步走的像素
     * */
    public void addAttackTimeline(ImageView imageView, List<Image> imagesRight, List<Image> imagesLeft, int durationMillis,
                                  int delayMillis, int moveDistance) {
        if (this.attackTimeline == null) {
            this.attackTimeline = new Timeline();
            this.attackTimeline.setCycleCount(1);
            this.attackTimeline.setAutoReverse(false);
            this.attackVariableAnimation = new VariableAnimation(imageView, imagesRight, imagesLeft, durationMillis, moveDistance,
                    this.operationHistoryThreadLocal, this.attackTimeline, 0);
            this.attackTimeline.setDelay(Duration.millis(delayMillis));
        }
    }

    /* 跑步功击动画
     * imageView 动画应用的图像
     * imagesRight 多个动画帧集合 右操作方向
     * imagesLeft 多个动画帧集合 左操作方向
     * durationMillis 动画的间隔时间
     * delayMillis 动画启动的延迟时间
     * moveDistance 每一步走的像素
     * */
    public void addHighAttackTimeline(ImageView imageView, List<Image> imagesRight, List<Image> imagesLeft, int durationMillis,
                                      int delayMillis, int moveDistance) {
        if (this.highAttackTimeline == null) {
            this.highAttackTimeline = new Timeline();
            this.highAttackTimeline.setCycleCount(1);
            this.highAttackTimeline.setAutoReverse(false);
            this.highAttackVariableAnimation = new VariableAnimation(imageView, imagesRight, imagesLeft, durationMillis, moveDistance,
                    this.operationHistoryThreadLocal, this.highAttackTimeline, 0);
            this.highAttackTimeline.setDelay(Duration.millis(delayMillis));
        }
    }


    /*
     * 关闭旧的动画 开始新的动画
     * */
    public void startAnimation(AnimationType animationType) {
        if (this.animationType != null) {
            switch (this.animationType) {
                case IDLE -> this.idleTimeline.stop();
                case ATTACK -> this.attackTimeline.stop();
                case HIGH_ATTACK -> this.highAttackTimeline.stop();
                case RUN -> this.runTimeline.stop();
                case HURT -> this.hurtTimeline.stop();
                case JUMP -> this.jumpTimeline.stop();
                case WALK -> this.walkTimeline.stop();
                case CLIMB -> this.climbTimeline.stop();
                case DEATH -> this.deathTimeline.stop();
            }
        }
        this.animationType = animationType;
        switch (this.animationType) {
            case IDLE -> this.idleTimeline.playFromStart();
            case ATTACK -> {
                this.attackVariableAnimation.startAttackVariableAnimation();
                this.attackTimeline.playFromStart();
            }
            case HIGH_ATTACK -> {
                this.highAttackVariableAnimation.startAttackVariableAnimation();
                this.highAttackTimeline.playFromStart();
            }
            case RUN -> this.runTimeline.playFromStart();
            case HURT -> this.hurtTimeline.playFromStart();
            case JUMP -> this.jumpTimeline.playFromStart();
            case WALK -> {
                this.walkVariableAnimation.startMoveVariableAnimation();
                this.walkTimeline.playFromStart();
            }
            case CLIMB -> this.climbTimeline.playFromStart();
            case DEATH -> this.deathTimeline.playFromStart();
        }
    }

    private static final class VariableAnimation {

        private final ImageView imageView;
        private final List<Image> imagesRight;
        private final List<Image> imagesLeft;
        private final int durationMillis;
        private final int moveDistance;
        private final ThreadLocal<OperationHistory> operationHistoryThreadLocal;
        private final Timeline walkTimeline;
        private final int operationHistoryDistance;
        //操作历史记录
        private OperationHistory operationHistoryCache;

        private VariableAnimation(ImageView imageView, List<Image> imagesRight, List<Image> imagesLeft,
                                  int durationMillis,
                                  int moveDistance,
                                  ThreadLocal<OperationHistory> operationHistoryThreadLocal,
                                  Timeline walkTimeline, int operationHistoryDistance) {
            this.imageView = imageView;
            this.imagesRight = imagesRight;
            this.imagesLeft = imagesLeft;
            this.durationMillis = durationMillis;
            this.moveDistance = moveDistance;
            this.operationHistoryThreadLocal = operationHistoryThreadLocal;
            this.walkTimeline = walkTimeline;
            this.operationHistoryDistance = operationHistoryDistance;
        }

        public void startMoveVariableAnimation() {
            this.walkTimeline.getKeyFrames().clear();
            if (this.operationHistoryCache == null) {
                this.operationHistoryCache = this.operationHistoryThreadLocal.get();
            } else if (this.operationHistoryCache != this.operationHistoryThreadLocal.get()) {
                if (this.operationHistoryThreadLocal.get() == OperationHistory.RIGHT) {
                    this.imageView.setLayoutX(this.imageView.getLayoutX() + operationHistoryDistance);
                    this.imageView.setImage(this.imagesRight.getFirst());
                } else {
                    this.imageView.setLayoutX(this.imageView.getLayoutX() - operationHistoryDistance);
                    this.imageView.setImage(this.imagesLeft.getFirst());
                }
                this.operationHistoryCache = this.operationHistoryThreadLocal.get();
                return;
            }
            for (int i = 0; i < this.imagesRight.size(); i++) {
                KeyValue keyValue = null;
                KeyFrame keyFrame = null;
                if (this.operationHistoryThreadLocal.get() == OperationHistory.RIGHT) {
                    keyValue = new KeyValue(imageView.layoutXProperty(), imageView.layoutXProperty().get() + (i * moveDistance));
                    keyFrame = new KeyFrame(Duration.millis(i * durationMillis), String.valueOf(i), event -> {
                        KeyFrame source = (KeyFrame) event.getSource();
                        int indexImage = Integer.parseInt(source.getName());
                        imageView.setImage(imagesRight.get(indexImage));
                    }, keyValue);
                } else {
                    keyValue = new KeyValue(imageView.layoutXProperty(), imageView.layoutXProperty().get() - (i * moveDistance));
                    keyFrame = new KeyFrame(Duration.millis(i * durationMillis), String.valueOf(i), event -> {
                        KeyFrame source = (KeyFrame) event.getSource();
                        int indexImage = Integer.parseInt(source.getName());
                        imageView.setImage(imagesLeft.get(indexImage));
                    }, keyValue);
                }
                this.walkTimeline.getKeyFrames().add(keyFrame);
            }
        }

        public void startAttackVariableAnimation() {
            this.walkTimeline.getKeyFrames().clear();
            for (int i = 0; i < this.imagesRight.size(); i++) {
                KeyFrame keyFrame;
                if (this.operationHistoryThreadLocal.get() == OperationHistory.RIGHT) {
                    keyFrame = new KeyFrame(Duration.millis(i * durationMillis), String.valueOf(i), event -> {
                        KeyFrame source = (KeyFrame) event.getSource();
                        int indexImage = Integer.parseInt(source.getName());
                        imageView.setImage(imagesRight.get(indexImage));
                    });
                } else {
                    keyFrame = new KeyFrame(Duration.millis(i * durationMillis), String.valueOf(i), event -> {
                        KeyFrame source = (KeyFrame) event.getSource();
                        int indexImage = Integer.parseInt(source.getName());
                        imageView.setImage(imagesLeft.get(indexImage));
                    });
                }
                this.walkTimeline.getKeyFrames().add(keyFrame);
            }
        }

        public void resetTranslateX() {
            this.imageView.setTranslateX(0);
        }

        public void startRunAttackVariableAnimation() {
            this.walkTimeline.getKeyFrames().clear();
            for (int i = 0; i < this.imagesRight.size(); i++) {
                KeyFrame keyFrame;
                KeyValue keyValue;
                if (this.operationHistoryThreadLocal.get() == OperationHistory.RIGHT) {
                    keyValue = new KeyValue(imageView.translateXProperty(), imageView.translateXProperty().get() + (i * moveDistance));
                    keyFrame = new KeyFrame(Duration.millis(i * durationMillis), String.valueOf(i), event -> {
                        KeyFrame source = (KeyFrame) event.getSource();
                        int indexImage = Integer.parseInt(source.getName());
                        imageView.setImage(imagesRight.get(indexImage));
                    }, keyValue);
                } else {
                    keyValue = new KeyValue(imageView.translateXProperty(), imageView.translateXProperty().get() - (i * moveDistance));
                    keyFrame = new KeyFrame(Duration.millis(i * durationMillis), String.valueOf(i), event -> {
                        KeyFrame source = (KeyFrame) event.getSource();
                        int indexImage = Integer.parseInt(source.getName());
                        imageView.setImage(imagesLeft.get(indexImage));
                    }, keyValue);
                }
                this.walkTimeline.getKeyFrames().add(keyFrame);
            }
        }

    }

    public static enum AnimationType {
        IDLE, ATTACK, HIGH_ATTACK, CLIMB, DEATH, HURT, JUMP, RUN, WALK;
    }

    public static enum OperationHistory {
        TOP, BOTTOM, LEFT, RIGHT;
    }

}

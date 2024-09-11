package com.example.javafxdemo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.Getter;

public class UserUiViewDemo extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        UserUiView userUiView = new UserUiView(100, 100);
        userUiView.initPane();
        root.getChildren().add(userUiView.getUiPane());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);
        primaryStage.setTitle("UserUiView");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Getter
    public static final class UserUiView {

        private final Pane uiPane = new Pane();
        private final int baseImageWidth = 64;
        private final ImageView imageViewOne = new ImageView();
        private final ImageView imageViewTwo = new ImageView();
        private final ImageView imageViewThree = new ImageView();
        private final ImageView imageViewFour = new ImageView();
        private final Image imageOne = new Image(UserUiView.class.getResourceAsStream("userUi/lava_tile1.png"));
        private final Image imageTwo = new Image(UserUiView.class.getResourceAsStream("userUi/lava_tile2.png"));

        public UserUiView(int baseX, int baseY) {
            this.uiPane.setLayoutX(baseX);
            this.uiPane.setLayoutY(baseY);
        }

        public void initPane() {
            Circle circle = new Circle();
            //设置圆中心点的XY位置
            circle.setCenterX(this.baseImageWidth);
            circle.setCenterY(this.baseImageWidth);
            //圆的半径
            circle.setRadius(this.baseImageWidth);
            circle.setFill(null);
            circle.setStrokeWidth(2);
            circle.setStroke(Color.RED);
            Arc leftTopArc = new Arc(64, 64, 64, 64, 90, 180);
            leftTopArc.setType(ArcType.ROUND);
            Arc rightTopArc = new Arc(0, 64, 64, 64, 0, 90);
            rightTopArc.setType(ArcType.ROUND);
            Arc leftBottomArc = new Arc(64, 0, 64, 64, 180, 270);
            leftBottomArc.setType(ArcType.ROUND);
            Arc rightBottomArc = new Arc(0, 0, 64, 64, 270, 360);
            rightBottomArc.setType(ArcType.ROUND);
            this.imageViewOne.setImage(imageOne);
            this.imageViewOne.setClip(leftTopArc);
            this.imageViewTwo.setImage(imageOne);
            this.imageViewTwo.setLayoutX(baseImageWidth);
            this.imageViewTwo.setClip(rightTopArc);
            this.imageViewThree.setImage(imageOne);
            this.imageViewThree.setLayoutY(baseImageWidth);
            this.imageViewThree.setClip(leftBottomArc);
            this.imageViewFour.setImage(imageOne);
            this.imageViewFour.setLayoutX(baseImageWidth);
            this.imageViewFour.setLayoutY(baseImageWidth);
            this.imageViewFour.setClip(rightBottomArc);
            this.uiPane.getChildren().addAll(this.imageViewOne, this.imageViewTwo, this.imageViewThree, this.imageViewFour, circle);
            Timeline timeline = new Timeline();
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.setAutoReverse(false);
            timeline.setDelay(Duration.millis(1000));
            for (int i = 1; i <= 2; i++) {
                KeyFrame keyFrame = new KeyFrame(Duration.millis(i * 200), String.valueOf(i), event -> {
                    KeyFrame source = (KeyFrame) event.getSource();
                    int indexImage = Integer.parseInt(source.getName());
                    if (indexImage == 1) {
                        this.imageViewOne.setImage(imageOne);
                        this.imageViewTwo.setImage(imageOne);
                        this.imageViewThree.setImage(imageOne);
                        this.imageViewFour.setImage(imageOne);
                    } else {
                        this.imageViewOne.setImage(imageTwo);
                        this.imageViewTwo.setImage(imageTwo);
                        this.imageViewThree.setImage(imageTwo);
                        this.imageViewFour.setImage(imageTwo);
                    }
                    this.imageViewOne.setY(this.imageViewOne.getY() + 1);//temp
                    this.imageViewTwo.setY(this.imageViewTwo.getY() + 1);//temp
                    this.imageViewThree.setY(this.imageViewThree.getY() + 1);//temp
                    this.imageViewFour.setY(this.imageViewFour.getY() + 1);//temp
                });
                timeline.getKeyFrames().add(keyFrame);
            }
            timeline.play();
        }
    }

}

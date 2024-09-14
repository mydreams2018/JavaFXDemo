package com.example.javafxdemo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
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
        private final Image BaseSkill = new Image(UserUiView.class.getResourceAsStream("userUi/scquare_border.png"));

        private final ImageView imageViewMagicOne = new ImageView();
        private final ImageView imageViewMagicTwo = new ImageView();
        private final ImageView imageViewMagicThree = new ImageView();
        private final ImageView imageViewMagicFour = new ImageView();
        private final Image imageMagicOne = new Image(UserUiView.class.getResourceAsStream("userUi/water_tile00.png"));
        private final Image imageMagicTwo = new Image(UserUiView.class.getResourceAsStream("userUi/water_tile01.png"));
        private final Image imageMagicThree = new Image(UserUiView.class.getResourceAsStream("userUi/water_tile02.png"));
        private final Image imageMagicFour = new Image(UserUiView.class.getResourceAsStream("userUi/water_tile03.png"));
        private final Image imageMagicFive = new Image(UserUiView.class.getResourceAsStream("userUi/water_tile04.png"));
        private final Image imageMagicSix = new Image(UserUiView.class.getResourceAsStream("userUi/water_tile05.png"));
        private final Image imageMagicSeven = new Image(UserUiView.class.getResourceAsStream("userUi/water_tile06.png"));
        private final Image imageMagicEight = new Image(UserUiView.class.getResourceAsStream("userUi/water_tile06.png"));

        public UserUiView(int baseX, int baseY) {
            this.uiPane.setLayoutX(baseX);
            this.uiPane.setLayoutY(baseY);
            this.uiPane.setPrefHeight(this.baseImageWidth * 2);
            this.uiPane.setBackground(Background.fill(Color.GREEN));
        }

        public void initPane() {
            this.initBloodView();
            String[] skillNames = {"移动", "跳跃", "普功", "重功", "变身", "无敌"};
            final int baseX = 138;
            for (int i = 0; i < 6; i++) {
                SkillView skillView = new SkillView(new ImageView(BaseSkill), new Label(skillNames[i]), i * 50 + baseX, (int) (128 - BaseSkill.getHeight() - 10));
                skillView.initLayout();
                this.uiPane.getChildren().addAll(skillView.getSkillsView());
            }
            this.initMagicView();
        }

        private void initBloodView() {
            Circle circle = new Circle();
            //设置圆中心点的XY位置
            circle.setCenterX(this.baseImageWidth);
            circle.setCenterY(this.baseImageWidth);
            //圆的半径
            circle.setRadius(this.baseImageWidth);
            circle.setFill(null);
            circle.setStrokeWidth(2);
            circle.setStroke(Color.RED);
            Arc leftTopArc = new Arc(64, 64, 64, 64, 90, 360);
            leftTopArc.setType(ArcType.ROUND);
            Arc rightTopArc = new Arc(0, 64, 64, 64, 0, 360);
            rightTopArc.setType(ArcType.ROUND);
            Arc leftBottomArc = new Arc(64, 0, 64, 64, 180, 360);
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
            this.runBloodAnimation();
        }

        public void runBloodAnimation() {
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

        private void initMagicView() {
            final int baseX = 438;
            Circle circle = new Circle();
            //设置圆中心点的XY位置
            circle.setCenterX(this.baseImageWidth + baseX);
            circle.setCenterY(this.baseImageWidth);
            //圆的半径
            circle.setRadius(this.baseImageWidth);
            circle.setFill(null);
            circle.setStrokeWidth(2);
            circle.setStroke(Color.SKYBLUE);
            Arc leftTopArc = new Arc(64, 64, 64, 64, 90, 360);
            leftTopArc.setType(ArcType.ROUND);
            Arc rightTopArc = new Arc(0, 64, 64, 64, 0, 360);
            rightTopArc.setType(ArcType.ROUND);
            Arc leftBottomArc = new Arc(64, 0, 64, 64, 180, 360);
            leftBottomArc.setType(ArcType.ROUND);
            Arc rightBottomArc = new Arc(0, 0, 64, 64, 270, 360);
            rightBottomArc.setType(ArcType.ROUND);
            this.imageViewMagicOne.setImage(imageMagicOne);
            this.imageViewMagicOne.setClip(leftTopArc);
            this.imageViewMagicOne.setLayoutX(baseX);
            this.imageViewMagicTwo.setImage(imageMagicOne);
            this.imageViewMagicTwo.setLayoutX(baseImageWidth + baseX);
            this.imageViewMagicTwo.setClip(rightTopArc);
            this.imageViewMagicThree.setImage(imageMagicOne);
            this.imageViewMagicThree.setLayoutX(baseX);
            this.imageViewMagicThree.setLayoutY(baseImageWidth);
            this.imageViewMagicThree.setClip(leftBottomArc);
            this.imageViewMagicFour.setImage(imageMagicOne);
            this.imageViewMagicFour.setLayoutX(baseImageWidth + baseX);
            this.imageViewMagicFour.setLayoutY(baseImageWidth);
            this.imageViewMagicFour.setClip(rightBottomArc);
            this.uiPane.getChildren().addAll(this.imageViewMagicOne, this.imageViewMagicTwo, this.imageViewMagicThree, this.imageViewMagicFour, circle);
            this.runMagicAnimation();
        }

        public void runMagicAnimation() {
            Timeline timeline = new Timeline();
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.setAutoReverse(false);
            timeline.setDelay(Duration.millis(1000));
            for (int i = 1; i <= 8; i++) {
                KeyFrame keyFrame = new KeyFrame(Duration.millis(i * 200), String.valueOf(i), event -> {
                    KeyFrame source = (KeyFrame) event.getSource();
                    int indexImage = Integer.parseInt(source.getName());
                    switch (indexImage) {
                        case 1 -> {
                            this.imageViewMagicOne.setImage(imageMagicOne);
                            this.imageViewMagicTwo.setImage(imageMagicOne);
                            this.imageViewMagicThree.setImage(imageMagicOne);
                            this.imageViewMagicFour.setImage(imageMagicOne);
                        }
                        case 2 -> {
                            this.imageViewMagicOne.setImage(imageMagicTwo);
                            this.imageViewMagicTwo.setImage(imageMagicTwo);
                            this.imageViewMagicThree.setImage(imageMagicTwo);
                            this.imageViewMagicFour.setImage(imageMagicTwo);
                        }
                        case 3 -> {
                            this.imageViewMagicOne.setImage(imageMagicThree);
                            this.imageViewMagicTwo.setImage(imageMagicThree);
                            this.imageViewMagicThree.setImage(imageMagicThree);
                            this.imageViewMagicFour.setImage(imageMagicThree);
                        }
                        case 4 -> {
                            this.imageViewMagicOne.setImage(imageMagicFour);
                            this.imageViewMagicTwo.setImage(imageMagicFour);
                            this.imageViewMagicThree.setImage(imageMagicFour);
                            this.imageViewMagicFour.setImage(imageMagicFour);
                        }
                        case 5 -> {
                            this.imageViewMagicOne.setImage(imageMagicFive);
                            this.imageViewMagicTwo.setImage(imageMagicFive);
                            this.imageViewMagicThree.setImage(imageMagicFive);
                            this.imageViewMagicFour.setImage(imageMagicFive);
                        }
                        case 6 -> {
                            this.imageViewMagicOne.setImage(imageMagicSix);
                            this.imageViewMagicTwo.setImage(imageMagicSix);
                            this.imageViewMagicThree.setImage(imageMagicSix);
                            this.imageViewMagicFour.setImage(imageMagicSix);
                        }
                        case 7 -> {
                            this.imageViewMagicOne.setImage(imageMagicSeven);
                            this.imageViewMagicTwo.setImage(imageMagicSeven);
                            this.imageViewMagicThree.setImage(imageMagicSeven);
                            this.imageViewMagicFour.setImage(imageMagicSeven);
                        }
                        case 8 -> {
                            this.imageViewMagicOne.setImage(imageMagicEight);
                            this.imageViewMagicTwo.setImage(imageMagicEight);
                            this.imageViewMagicThree.setImage(imageMagicEight);
                            this.imageViewMagicFour.setImage(imageMagicEight);
                        }
                    }

                    this.imageViewMagicOne.setY(this.imageViewMagicOne.getY() + 1);//temp
                    this.imageViewMagicTwo.setY(this.imageViewMagicTwo.getY() + 1);//temp
                    this.imageViewMagicThree.setY(this.imageViewMagicThree.getY() + 1);//temp
                    this.imageViewMagicFour.setY(this.imageViewMagicFour.getY() + 1);//temp
                });
                timeline.getKeyFrames().add(keyFrame);
            }
            timeline.play();
        }
    }

    @Getter
    public static final class SkillView {
        private final ImageView skillImage;
        private final Label skillName;
        private final int lx;
        private final int ly;
        private final Node[] skillsView = new Node[2];

        public SkillView(ImageView skillImage, Label skillName, int lx, int ly) {
            this.skillImage = skillImage;
            this.skillName = skillName;
            this.lx = lx;
            this.ly = ly;
            this.skillsView[0] = this.skillImage;
            this.skillsView[1] = this.skillName;
        }

        public void initLayout() {
            this.skillImage.setLayoutX(this.lx);
            this.skillImage.setLayoutY(this.ly);
            this.skillName.setPrefWidth(this.skillImage.getImage().getWidth());
            this.skillName.setPrefHeight(this.skillImage.getImage().getHeight());
            this.skillName.setAlignment(Pos.CENTER);
            this.skillName.setLayoutX(this.lx);
            this.skillName.setLayoutY(this.ly);
        }
    }

}

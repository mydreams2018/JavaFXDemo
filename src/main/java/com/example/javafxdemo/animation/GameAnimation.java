package com.example.javafxdemo.animation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GameAnimation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        root.setAutoSizeChildren(false);
        ImageView imageView = new ImageView();

        List<Image> imageList = new ArrayList<>();
        URL idleAnimation = ClassLoader.getSystemResource("Idle/");
        File file = new File(idleAnimation.toURI());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (int i = 1; i <= listFiles.length; i++) {
                imageList.add(new Image(new File(file, "idle" + i + ".png").toURI().toString()));
            }
        }

        List<Image> imageListWalkRight = new ArrayList<>();
        URL idleAnimationWalkRight = ClassLoader.getSystemResource("Walk/right/");
        File fileWalkRight = new File(idleAnimationWalkRight.toURI());
        if (fileWalkRight.exists() && fileWalkRight.isDirectory()) {
            File[] listFiles = fileWalkRight.listFiles();
            for (int i = 1; i <= listFiles.length; i++) {
                imageListWalkRight.add(new Image(new File(fileWalkRight, "walk" + i + ".png").toURI().toString()));
            }
        }

        List<Image> imageListWalkLeft = new ArrayList<>();
        URL idleAnimationWalkLeft = ClassLoader.getSystemResource("Walk/left/");
        File fileWalkLeft = new File(idleAnimationWalkLeft.toURI());
        if (fileWalkLeft.exists() && fileWalkLeft.isDirectory()) {
            File[] listFiles = fileWalkLeft.listFiles();
            for (int i = 1; i <= listFiles.length; i++) {
                imageListWalkLeft.add(new Image(new File(fileWalkLeft, "walk" + i + ".png").toURI().toString()));
            }
        }

        List<Image> imageListAttackRight = new ArrayList<>();
        URL idleAnimationAttackRight = ClassLoader.getSystemResource("Walk_Attack/right/");
        File fileAttackRight = new File(idleAnimationAttackRight.toURI());
        if (fileAttackRight.exists() && fileAttackRight.isDirectory()) {
            File[] listFiles = fileAttackRight.listFiles();
            for (int i = 1; i <= listFiles.length; i++) {
                imageListAttackRight.add(new Image(new File(fileAttackRight, "walk_attack" + i + ".png").toURI().toString()));
            }
        }

        List<Image> imageListAttackLeft = new ArrayList<>();
        URL idleAnimationAttackLeft = ClassLoader.getSystemResource("Walk_Attack/left/");
        File fileAttackLeft = new File(idleAnimationAttackLeft.toURI());
        if (fileAttackLeft.exists() && fileAttackLeft.isDirectory()) {
            File[] listFiles = fileAttackLeft.listFiles();
            for (int i = 1; i <= listFiles.length; i++) {
                imageListAttackLeft.add(new Image(new File(fileAttackLeft, "walk_attack" + i + ".png").toURI().toString()));
            }
        }

        IntegrationAnimation integrationAnimation = new IntegrationAnimation();
        integrationAnimation.getOperationHistoryThreadLocal().set(IntegrationAnimation.OperationHistory.RIGHT);
        integrationAnimation.addIdleTimeline(imageView, imageList, 100, 1000);
        integrationAnimation.addWalkTimeline(imageView, imageListWalkRight, imageListWalkLeft, 100, 0,
                8, 43);
        integrationAnimation.addAttackTimeline(imageView, imageListAttackRight, imageListAttackLeft, 100, 0,
                8, 43);
        integrationAnimation.startAnimation(IntegrationAnimation.AnimationType.IDLE);

        root.getChildren().add(imageView);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.J && integrationAnimation.getAttackDurationControl().changeOpacity()) {
                integrationAnimation.startAnimation(IntegrationAnimation.AnimationType.ATTACK);

            }
            if (event.getCode() == KeyCode.D && integrationAnimation.getMoveDurationControl().changeOpacity()) {
                integrationAnimation.getOperationHistoryThreadLocal().set(IntegrationAnimation.OperationHistory.RIGHT);
                integrationAnimation.startAnimation(IntegrationAnimation.AnimationType.WALK);
            }
            if (event.getCode() == KeyCode.A && integrationAnimation.getMoveDurationControl().changeOpacity()) {
                integrationAnimation.getOperationHistoryThreadLocal().set(IntegrationAnimation.OperationHistory.LEFT);
                integrationAnimation.startAnimation(IntegrationAnimation.AnimationType.WALK);
            }
        });
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);
        primaryStage.setTitle("游戏人物动画测试");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

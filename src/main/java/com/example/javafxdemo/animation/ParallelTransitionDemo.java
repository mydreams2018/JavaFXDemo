package com.example.javafxdemo.animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ParallelTransitionDemo extends Application {
    /*
    * SequentialTransition 串行动画
    * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Rectangle rect = new Rectangle (0, 0, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setFill(Color.VIOLET);

        final Duration SEC_2 = Duration.millis(2000);
        final Duration SEC_3 = Duration.millis(3000);

        FadeTransition ft = new FadeTransition(SEC_3);
        ft.setFromValue(1.0f);
        ft.setToValue(0.3f);
        ft.setCycleCount(2);
        ft.setAutoReverse(true);
        TranslateTransition tt = new TranslateTransition(SEC_2);
        tt.setFromX(0);
        tt.setToX(100f);
        tt.setCycleCount(2);
        tt.setAutoReverse(true);
        RotateTransition rt = new RotateTransition(SEC_3);
        rt.setByAngle(180f);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);
        ScaleTransition st = new ScaleTransition(SEC_2);
        st.setByX(1.5f);
        st.setByY(1.5f);
        st.setCycleCount(2);
        st.setAutoReverse(true);

        //并行动画多个动画合体
        ParallelTransition pt = new ParallelTransition(rect, ft, tt, rt, st);
        pt.play();

        root.getChildren().addAll(rect);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Transition Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

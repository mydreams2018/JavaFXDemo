package com.example.javafxdemo.animation;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class TransitionDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        final String content = "Lorem ipsum";
        final Text text = new Text(10, 20, "");

        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
            }
            protected void interpolate(double frac) {
                final int n = Math.round(content.length() * (float) frac);
                //效率太低了 重复进来此方法里
                if (text.getText().length() < n){
                    System.out.println(n);
                    text.setText(content.substring(0, n));
                }
            }
        };
        animation.play();

        root.getChildren().add(text);
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

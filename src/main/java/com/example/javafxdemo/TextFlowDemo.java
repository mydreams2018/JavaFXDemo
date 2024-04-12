package com.example.javafxdemo;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TextFlowDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox root = new HBox();

        Text world = new Text("The Insets used by tblCustomers omits any top spacing to keep the spacing even. JavaFX does not consolidate " +
                "whitespace as in web design. If the top Inset were set to 10.0d for the TableView, the distance between the top controls " +
                "and the TableView would be twice as wide as the distance between any of the other controls");
        Button button = new Button("Click me");
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            FadeTransition fadeTransition = new FadeTransition();
            fadeTransition.setNode(root);
//                fadeTransition.setCycleCount(4);
//                fadeTransition.setAutoReverse(true);
            //设置持续时间属性的值
            fadeTransition.setDuration(Duration.millis(300));
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();
        });
        //文本浮动效果
        TextFlow textFlow = new TextFlow();
        textFlow.getChildren().add(world);
        //行边距
        textFlow.setLineSpacing(5);

        root.getChildren().addAll(textFlow, button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("FlowPane Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

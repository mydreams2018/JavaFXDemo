package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TitlePaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();

        Accordion accordion = new Accordion();

        TitledPane titledPane = new TitledPane();
        titledPane.setExpanded(false);
        titledPane.setCollapsible(true);
        titledPane.setText("TitledPane Demo");
        titledPane.setContent(new Button("button"));

        TitledPane titledPane2 = new TitledPane();
        titledPane2.setExpanded(false);
        titledPane2.setCollapsible(true);
        titledPane2.setText("TitledPane Demo2");
        titledPane2.setContent(new Button("button2"));
        titledPane2.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        accordion.getPanes().addAll(titledPane,titledPane2);

        root.getChildren().add(accordion);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TitlePane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

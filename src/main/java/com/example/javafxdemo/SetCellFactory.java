package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SetCellFactory extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox();
        ComboBox<Color> cmb = new ComboBox<>();
        cmb.getItems().addAll(Color.RED, Color.GREEN, Color.BLUE);
        cmb.setCellFactory(p -> new ListCell<>() {
            private final Rectangle rectangle;

            {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                rectangle = new Rectangle(10, 10);
            }

            @Override
            protected void updateItem(Color item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    rectangle.setFill(item);
                    setGraphic(rectangle);
                    setText(item.toString());
                }
            }
        });

        hbox.getChildren().add(cmb);
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

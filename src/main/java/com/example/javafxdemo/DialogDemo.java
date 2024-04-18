package com.example.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        Button button = new Button("Button");

        final MyDialog myDialog = new MyDialog();

        button.setOnAction(event -> myDialog.showAndWait());

        root.getChildren().add(button);
        Scene scene = new Scene(root);
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

    public static final class MyDialog extends Dialog<String> {

        public MyDialog() {
            ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            this.setTitle("Login Dialog");
            this.setContentText("Would you like to log in?");
            this.getDialogPane().getButtonTypes().addAll(loginButtonType, cancelButtonType);
            Button btn = (Button) this.getDialogPane().lookupButton(loginButtonType);
            btn.setDisable(false);
            btn.addEventFilter(ActionEvent.ACTION, btnEvent -> {
                System.out.println(btnEvent);
            });
        }

    }

}

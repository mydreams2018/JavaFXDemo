package com.example.javafxdemo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.ActionListener;

public class SystemHide extends Application {
    /*
     * 系统托盘
     * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
         * 如果此属性为true则当最后一个窗口关闭时 JavaFX运行时将隐式关闭 JavaFX启动器将调用该应用程序stop
         *  并终止JavaFX应用程序线程 如果此属性为false 则即使在最后一个窗口关闭后 应用程序也将继续正常运行
         *   直到应用程序调用exit为止
         * */
        Platform.setImplicitExit(false);

        HBox root = new HBox();
        Button buttonA = new Button("hide system");
        Button buttonB = new Button("restart system");
        //添加系统托盘
        addSystemTray(primaryStage);

        buttonA.setOnAction(event -> primaryStage.hide());

        root.getChildren().addAll(buttonA, buttonB);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("系统托盘");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public void addSystemTray(Stage primaryStage) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("favicon.ico");
            ActionListener listener = e -> {
                if ("cancel".equals(e.getActionCommand())) {
                    TrayIcon[] trayIcons = tray.getTrayIcons();
                    for (TrayIcon trayIcon : trayIcons) {
                        tray.remove(trayIcon);
                    }
                    Platform.exit();
                } else if ("recovery".equals(e.getActionCommand())) {
                    if (!primaryStage.isShowing()) {
                        Platform.runLater(() -> primaryStage.show());
                    }
                }
            };
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem(" cancel ");
            MenuItem reStart = new MenuItem(" recovery ");
            reStart.addActionListener(listener);
            defaultItem.addActionListener(listener);
            popup.add(defaultItem);
            popup.add(reStart);
            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo", popup);
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

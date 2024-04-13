package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MenuBarDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        ImageView imageView = new ImageView("https://www.kungreat.cn/favicon.ico");
        imageView.setFitHeight(18);
        imageView.setFitWidth(18);
        file.getItems().add(new MenuItem("New", imageView));
        MenuItem open = new MenuItem("open");
        //菜单快捷键
        open.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.ALT_DOWN));
        open.setOnAction(event -> System.out.println("ActionEvent"));
        file.getItems().add(open);
        Menu save = new Menu("save");
        //SeparatorMenuItem 就是一个菜单分割线
        save.getItems().addAll(new MenuItem("Save"), new SeparatorMenuItem(), new MenuItem("Save As"));

        Menu cancel = new Menu("cancel");
        cancel.getItems().addAll(new MenuItem("Cancel"), new SeparatorMenuItem(), new MenuItem("Cancel"));
        //嵌套菜单
        save.getItems().add(cancel);

        Menu single = new Menu("single");
        //组内 单选菜单  CheckMenuItem多选菜单
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem radioMenuItem = new RadioMenuItem("SingleA");
        RadioMenuItem radioMenuItem2 = new RadioMenuItem("SingleB");
        //默认选中
        radioMenuItem2.setSelected(true);
        radioMenuItem.setToggleGroup(toggleGroup);
        radioMenuItem2.setToggleGroup(toggleGroup);
        //自定义菜单
        CustomMenuItem customMenuItem = new CustomMenuItem();
        customMenuItem.setContent(new ProgressBar(0.5));
        single.getItems().addAll(radioMenuItem, radioMenuItem2, customMenuItem);


        menuBar.getMenus().addAll(file, save, single);
        root.setTop(menuBar);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("MenuBar Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

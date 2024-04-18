package com.example.javafxdemo.table;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TreeViewDemo extends Application {

    /*
    * TreeCell.setDisclosureNode(Node value)   用作披露三角形或切换的节点 用于展开和折叠项
    * */

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        TreeView<String> treeView = new TreeView<>();
        TreeItem<String> treeItem = new TreeItem<>("Root Node");
        treeItem.setExpanded(true);
        treeItem.getChildren().addAll(new TreeItem<>("Item 1"), new TreeItem<>("Item 2"), new TreeItem<>("Item 3"));
        treeView.setRoot(treeItem);
        treeView.setEditable(true);
        treeView.setCellFactory(TextFieldTreeCell.forTreeView());
//        treeView.setCellFactory(CheckBoxTreeCell.forTreeView());
        treeView.setFixedCellSize(30);
        //是否显示根节点
        treeView.setShowRoot(true);
        treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //所有展开的节点数量
        System.out.println(treeView.expandedItemCountProperty());


        treeItem.addEventHandler(TreeItem.childrenModificationEvent(), new EventHandler<TreeItem.TreeModificationEvent<String>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<String> event) {
                System.out.println(event);
            }
        });
        treeItem.addEventHandler(TreeItem.treeNotificationEvent(), new EventHandler<TreeItem.TreeModificationEvent<Object>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<Object> event) {
                System.out.println(event);
            }
        });
        treeItem.addEventHandler(TreeItem.valueChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<Object>>() {
            @Override
            public void handle(TreeItem.TreeModificationEvent<Object> event) {
                System.out.println(event);
            }
        });


        root.getChildren().add(treeView);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TableView Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

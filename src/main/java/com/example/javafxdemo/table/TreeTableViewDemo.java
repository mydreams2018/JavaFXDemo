package com.example.javafxdemo.table;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

public class TreeTableViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        File rootFile = new File("Images", 900,1000);
        List<File> files = List.of(new File("Cat.png", 300,1000),
                new File("Dog.png", 500,1000), new File("Bird.png", 100,60000));
        TreeItem<File> itemRoot = new TreeItem<>(rootFile);
        files.forEach(file -> itemRoot.getChildren().add(new TreeItem<>(file)));
        TreeTableView<File> treeTable = new TreeTableView<>(itemRoot);
        itemRoot.setExpanded(true);
        TreeTableColumn<File, String> fileNameCol = new TreeTableColumn<>("名称");
        TreeTableColumn<File, Long> sizeCol = new TreeTableColumn<>("大小");
        TreeTableColumn<File, Long> lastModifiedCol = new TreeTableColumn<>("修改日期");

        fileNameCol.setCellValueFactory(new TreeItemPropertyValueFactory(rootFile.nameProperty().getName()));
        sizeCol.setCellValueFactory(new TreeItemPropertyValueFactory(rootFile.sizeProperty().getName()));
        lastModifiedCol.setCellValueFactory(new TreeItemPropertyValueFactory(rootFile.lastModifiedProperty().getName()));

        treeTable.getColumns().setAll(fileNameCol, sizeCol , lastModifiedCol);
        treeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        HBox root = new HBox();
        root.getChildren().add(treeTable);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TreeTableView Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static final class File {
        private StringProperty name;
        private IntegerProperty size;
        private LongProperty lastModified;

        public File(String name, int size, long lastModified) {
            setName(name);
            setSize(size);
            setLastModified(lastModified);
        }

        public int getSize() {
            return size.get();
        }

        public IntegerProperty sizeProperty() {
            if (size == null) size = new SimpleIntegerProperty(this, "size");
            return size;
        }

        public void setSize(int size) {
            sizeProperty().set(size);
        }

        public void setName(String value) {
            nameProperty().set(value);
        }

        public String getName() {
            return nameProperty().get();
        }

        public StringProperty nameProperty() {
            if (name == null) name = new SimpleStringProperty(this, "name");
            return name;
        }

        public void setLastModified(long value) {
            lastModifiedProperty().set(value);
        }

        public long getLastModified() {
            return lastModifiedProperty().get();
        }

        public LongProperty lastModifiedProperty() {
            if (lastModified == null) lastModified = new SimpleLongProperty(this, "lastModified");
            return lastModified;
        }
    }
}

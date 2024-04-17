package com.example.javafxdemo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ListViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
//        root.setPadding(new Insets(0, 0, 0, 2));

        ListView<ListData> listView = new ListView<>();
        listView.getItems().addAll(new ListData("one",158),new ListData("two",158),new ListData("three",158));
        listView.setMaxSize(300,500);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setEditable(false);
        listView.setFixedCellSize(30);
        //默认选中第一个元素
        listView.getSelectionModel().select(1);
//        listView.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID,new CornerRadii(10),new BorderWidths(2))));
        //只读访问此组件子对象列表 root.getChildrenUnmodifiable()

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ListData>() {
            @Override
            public void changed(ObservableValue<? extends ListData> observable, ListData oldValue, ListData newValue) {
                System.out.println(newValue);
            }
        });

        Button button = new Button("Click me");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //拿到所有已经选择的数据
                System.out.println(listView.getSelectionModel().getSelectedItems());
            }
        });

        root.getChildren().addAll(listView,button);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Dragboard Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public final static class ListData {
        private String name;
        private int age;
        public ListData(String name, int age){
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

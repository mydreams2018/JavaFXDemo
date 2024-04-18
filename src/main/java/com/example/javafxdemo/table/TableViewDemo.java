package com.example.javafxdemo.table;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

public class TableViewDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        //决定了有多少行数据
        List<Person> members = List.of(new Person("William", "Reed"), new Person("James", "Michaelson"), new Person("Julius", "Dean"));
        ObservableList<Person> teamMembers = FXCollections.observableArrayList(members);
        TableView<Person> table = new TableView<>();
        table.setItems(teamMembers);
        //手动控制需要隐藏的列
        table.setTableMenuButtonVisible(true);
        //行和列定位到 一个单元格的大小
        table.setFixedCellSize(30);
        //有几个列的设计
        TableColumn<Person, String> firstNameCol = new TableColumn<>("第一名称");
        //字段名称
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        //列的宽度
        firstNameCol.setPrefWidth(200);
        //是否允许排序
        firstNameCol.setSortable(true);
        TableColumn<Person, String> lastNameCol = new TableColumn<>("第二名称");
        //字段名称
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //分组合并
        TableColumn<Person, String> group = new TableColumn<>("名称");
        group.getColumns().setAll(firstNameCol, lastNameCol);


        System.out.println(table.getColumns().add(group));

        //可编辑列
        table.setEditable(true);
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        //排序的优先级
        table.getSortOrder().setAll(firstNameCol, lastNameCol);

        //设置表格的自适应模式
        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

//        table.getSelectionModel().setCellSelectionEnabled(true); 选择单元格 没意义

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        table.refresh();强制刷新数据

        root.getChildren().add(table);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TableView Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            @Override
            public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
                //注意 -> 多选择模式下存在取消选择 newValue 可能为空
                System.out.println(newValue);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    /*
    * JavaBean 规范 get set
    * */
    public static class Person {
        private StringProperty firstName;
        private StringProperty lastName;

        public Person(String firstName, String lastName) {
            setFirstName(firstName);
            setLastName(lastName);
        }

        public void setFirstName(String value) {
            firstNameProperty().set(value);
        }

        public String getFirstName() {
            return firstNameProperty().get();
        }

        public StringProperty firstNameProperty() {
            if (firstName == null) firstName = new SimpleStringProperty(this, "firstName");
            return firstName;
        }

        public void setLastName(String value) {
            lastNameProperty().set(value);
        }

        public String getLastName() {
            return lastNameProperty().get();
        }

        public StringProperty lastNameProperty() {
            if (lastName == null) lastName = new SimpleStringProperty(this, "lastName");
            return lastName;
        }

    }
}

package com.example.javafxdemo.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class BarChartDemo extends Application {

    /*
    * StackedBarChart 子类
    * */
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("国家");
        NumberAxis yAxis = new NumberAxis("GDP年-万亿", 0, 200, 20);

        ObservableList<XYChart.Series<String, Number>> barChartList = FXCollections.observableArrayList();

        ObservableList<XYChart.Data<String,Number>> dataList = FXCollections.observableArrayList();
        dataList.add(new XYChart.Data<>("中国",60));
        dataList.add(new XYChart.Data<>("美国",180));
        dataList.add(new XYChart.Data<>("法国",30));
        dataList.add(new XYChart.Data<>("日本",35));
        dataList.add(new XYChart.Data<>("韩国",20));
        dataList.add(new XYChart.Data<>("朝线",0.1));
        dataList.add(new XYChart.Data<>("冰岛",1));
        dataList.add(new XYChart.Data<>("摩罗哥",2));

        ObservableList<XYChart.Data<String,Number>> dataListTwo = FXCollections.observableArrayList();
        dataListTwo.add(new XYChart.Data<>("中国",80));
        dataListTwo.add(new XYChart.Data<>("美国",190));
        dataListTwo.add(new XYChart.Data<>("法国",30));
        dataListTwo.add(new XYChart.Data<>("日本",18));
        dataListTwo.add(new XYChart.Data<>("韩国",20));
        dataListTwo.add(new XYChart.Data<>("朝线",26));
        dataListTwo.add(new XYChart.Data<>("冰岛",0.5));
        dataListTwo.add(new XYChart.Data<>("摩罗哥",0.8));

        XYChart.Series<String, Number> series1 = new XYChart.Series<>("2018",dataList);
        XYChart.Series<String, Number> series2 = new XYChart.Series<>("2019",dataListTwo);
        barChartList.addAll(series1,series2);

        BarChart<String, Number> stringNumberBarChart = new BarChart<>(xAxis, yAxis, barChartList);


        stringNumberBarChart.getData().forEach(new Consumer<XYChart.Series<String, Number>>() {
            @Override
            public void accept(XYChart.Series<String, Number> stringNumberSeries) {
                stringNumberSeries.getData().forEach(new Consumer<XYChart.Data<String, Number>>() {
                    @Override
                    public void accept(XYChart.Data<String, Number> data) {
                        Node node = data.getNode();
                        node.getStyleClass().add("hoverScaleX");
                    }
                });
            }
        });

        stringNumberBarChart.setAnimated(true);
        
        anchorPane.getChildren().add(stringNumberBarChart);
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(PieChartDemo.class.getResource("chart.css").toExternalForm());
        primaryStage.setTitle("柱状图");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

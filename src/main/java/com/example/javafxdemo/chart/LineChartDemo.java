package com.example.javafxdemo.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LineChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("国家");
        NumberAxis yAxis = new NumberAxis("GDP年-万亿", -20, 200, 20);

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
        dataListTwo.add(new XYChart.Data<>("摩罗哥",-12));

        XYChart.Series<String, Number> series1 = new XYChart.Series<>("2018",dataList);
        XYChart.Series<String, Number> series2 = new XYChart.Series<>("2019",dataListTwo);
        ObservableList<XYChart.Series<String, Number>> barChartList = FXCollections.observableArrayList();
        barChartList.addAll(series1,series2);

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis, barChartList);

        lineChart.getData().forEach(stringNumberSeries -> stringNumberSeries.getData().forEach(data -> {
            Node node = data.getNode();
            node.getStyleClass().add("hoverScaleX");
            Tooltip.install(node,new Tooltip(data.getYValue().toString()));
        }));
        lineChart.setAnimated(true);
        lineChart.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        //如果此值为 true 且垂直轴同时具有正值和负值 那么将在零点绘制一条额外的轴线
        lineChart.setVerticalZeroLineVisible(true);
        //如果应该绘制垂直网格线 那么为 True
        lineChart.setVerticalGridLinesVisible(true);
        
        anchorPane.getChildren().add(lineChart);
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(PieChartDemo.class.getResource("chart.css").toExternalForm());
        primaryStage.setTitle("折线图");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

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

public class BubbleChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        /*
         * Axis type incorrect, X and Y should both be NumberAxis
         * 为序列中的数据点绘制气泡的图表类型
         * */

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("国家");
        NumberAxis yAxis = new NumberAxis("GDP年-万亿", -20, 200, 20);

        ObservableList<XYChart.Data<Number, Number>> dataList = FXCollections.observableArrayList();
        dataList.add(new XYChart.Data<>(30, 60));
        dataList.add(new XYChart.Data<>(90, 180));
        dataList.add(new XYChart.Data<>(15, 30));
        dataList.add(new XYChart.Data<>(17, 35));
        dataList.add(new XYChart.Data<>(10, 20));
        dataList.add(new XYChart.Data<>(0.05, 0.1));
        dataList.add(new XYChart.Data<>(0.5, 1));
        dataList.add(new XYChart.Data<>(1, 2));

        ObservableList<XYChart.Data<Number, Number>> dataListTwo = FXCollections.observableArrayList();
        dataListTwo.add(new XYChart.Data<>(40, 80));
        dataListTwo.add(new XYChart.Data<>(95, 190));
        dataListTwo.add(new XYChart.Data<>(15, 30));
        dataListTwo.add(new XYChart.Data<>(9, 18));
        dataListTwo.add(new XYChart.Data<>(10, 20));
        dataListTwo.add(new XYChart.Data<>(13, 26));
        dataListTwo.add(new XYChart.Data<>(0.25, 0.5));
        dataListTwo.add(new XYChart.Data<>(-24, -12));

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>("2018", dataList);
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>("2019", dataListTwo);
        ObservableList<XYChart.Series<Number, Number>> barChartList = FXCollections.observableArrayList();
        barChartList.addAll(series1, series2);

        BubbleChart<Number, Number> bubbleChart = new BubbleChart<>(xAxis, yAxis, barChartList);

        bubbleChart.getData().forEach(stringNumberSeries -> stringNumberSeries.getData().forEach(data -> {
            Node node = data.getNode();
            node.getStyleClass().add("hoverScaleX");
            Tooltip.install(node, new Tooltip(data.getYValue().toString()));
            //数据的额外值属性用于表示气泡的半径
            data.setExtraValue(3);
        }));
        bubbleChart.setAnimated(true);
        bubbleChart.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        //如果此值为 true 且垂直轴同时具有正值和负值 那么将在零点绘制一条额外的轴线
        bubbleChart.setVerticalZeroLineVisible(true);
        //如果应该绘制垂直网格线 那么为 True
        bubbleChart.setVerticalGridLinesVisible(true);

        anchorPane.getChildren().add(bubbleChart);
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(PieChartDemo.class.getResource("chart.css").toExternalForm());
        primaryStage.setTitle("气泡图");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

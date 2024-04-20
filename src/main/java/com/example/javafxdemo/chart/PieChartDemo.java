package com.example.javafxdemo.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class PieChartDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        PieChart pieChart = new PieChart();

        ObservableList<PieChart.Data> pieChartList = FXCollections.observableArrayList();
        pieChartList.add(new PieChart.Data("Pie Chart Demo", 300));
        pieChartList.add(new PieChart.Data("Pie Chart Demo 2", 200));
        pieChartList.add(new PieChart.Data("Pie Chart Demo 3", 100));
        pieChartList.add(new PieChart.Data("Pie Chart Demo 4", 200));
        pieChartList.add(new PieChart.Data("Pie Chart Demo 5", 100));
        pieChart.setData(pieChartList);
        pieChart.setLegendSide(Side.BOTTOM);
        pieChart.setAnimated(true);
        pieChart.setLabelLineLength(6);

        pieChart.getData().forEach(new Consumer<PieChart.Data>() {
            @Override
            public void accept(PieChart.Data data) {
                Node node = data.getNode();
                node.getStyleClass().add("hoverScale");
            }
        });

        anchorPane.getChildren().add(pieChart);
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(PieChartDemo.class.getResource("chart.css").toExternalForm());
        primaryStage.setTitle("饼状图");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

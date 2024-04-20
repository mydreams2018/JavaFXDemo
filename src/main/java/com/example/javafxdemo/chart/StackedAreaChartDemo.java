package com.example.javafxdemo.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StackedAreaChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("国家");
        NumberAxis yAxis = new NumberAxis("GDP年-万亿", 0, 200, 20);
        ObservableList<XYChart.Series<String, Number>> barChartList = FXCollections.observableArrayList();

        ObservableList<XYChart.Data<String, Number>> dataList = FXCollections.observableArrayList();
        dataList.add(new XYChart.Data<>("中国", 60));
        dataList.add(new XYChart.Data<>("美国", 180));
        dataList.add(new XYChart.Data<>("法国", 30));
        dataList.add(new XYChart.Data<>("日本", 35));
        dataList.add(new XYChart.Data<>("韩国", 20));
        dataList.add(new XYChart.Data<>("朝线", 0.1));
        dataList.add(new XYChart.Data<>("冰岛", 1));
        dataList.add(new XYChart.Data<>("摩罗哥", 2));

        ObservableList<XYChart.Data<String, Number>> dataListTwo = FXCollections.observableArrayList();
        dataListTwo.add(new XYChart.Data<>("中国", 80));
        dataListTwo.add(new XYChart.Data<>("美国", 190));
        dataListTwo.add(new XYChart.Data<>("法国", 30));
        dataListTwo.add(new XYChart.Data<>("日本", 18));
        dataListTwo.add(new XYChart.Data<>("韩国", 20));
        dataListTwo.add(new XYChart.Data<>("朝线", 26));
        dataListTwo.add(new XYChart.Data<>("冰岛", 0.5));
        dataListTwo.add(new XYChart.Data<>("摩罗哥", 0.8));

        XYChart.Series<String, Number> series1 = new XYChart.Series<>("2018", dataList);
        XYChart.Series<String, Number> series2 = new XYChart.Series<>("2019", dataListTwo);
        barChartList.addAll(series1, series2);

        StackedAreaChart<String, Number> areaChart = new StackedAreaChart<>(xAxis, yAxis, barChartList);

        areaChart.setAnimated(true);
        //绘制连接点
        areaChart.setCreateSymbols(true);
       /* BlendMode 用于将此个别节点融合到后面的场景中
         如果此节点是组那么所有子代都将使用它们自己的混合方式单独组合到临时缓冲区中
         然后使用指定的混合方式将临时缓冲区合并到场景中
         areaChart.setBlendMode(BlendMode.GREEN);
         */
        //如果此值为 true 且垂直轴同时具有正值和负值 那么将在零点绘制一条额外的轴线
        areaChart.setVerticalZeroLineVisible(true);
        areaChart.setHorizontalZeroLineVisible(true);
        //如果应该绘制垂直网格线 那么为 True
        areaChart.setVerticalGridLinesVisible(true);
        areaChart.setHorizontalGridLinesVisible(true);

        anchorPane.getChildren().add(areaChart);
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(StackedAreaChartDemo.class.getResource("chart.css").toExternalForm());
        primaryStage.setTitle("折线图 数据是累加的效果");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

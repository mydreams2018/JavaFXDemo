package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Arrays;

public class SplitPaneDemo extends Application {
    /*
     * 面板自适应分割
     * */

    @Override
    public void start(Stage primaryStage) throws Exception {
        SplitPane sp = new SplitPane();

        final StackPane sp1 = new StackPane();
        //最小宽度 可以限制SplitPane 在缩小时此组件的一个最小宽度
        sp1.setMinWidth(100);
        sp1.getChildren().add(new Button("Button One"));
        final StackPane sp2 = new StackPane();
        sp2.getChildren().add(new Button("Button Two"));
        final StackPane sp3 = new StackPane();
        sp3.getChildren().add(new Button("Button Three"));

        sp.getItems().addAll(sp1, sp2, sp3);

        //设置分隔器的位置 在 0.0 到 1.0 ( 含 ) 之间
/*        sp.setDividerPosition(0, 0.3f);
        sp.setDividerPosition(1, 0.6f);
        */
        sp.setDividerPositions(0.3, 0.6f);
        System.out.println(Arrays.toString(sp.getDividerPositions()));
        //横向 纵向
        sp.setOrientation(Orientation.HORIZONTAL);
  /*
        sp2 具有ResizableWithParent功能 具有自动拉升功能不见意设置此
        SplitPane.setResizableWithParent(sp1, false);
        SplitPane.setResizableWithParent(sp2, true);
        SplitPane.setResizableWithParent(sp3, false);
        */
        Scene scene = new Scene(sp);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

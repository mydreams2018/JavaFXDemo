package com.example.javafxdemo.games;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class PathDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        /*
        * 路径类表示简单的形状 并提供基本构造和管理几何路径所需的设施
        * ArcTo, ClosePath, CubicCurveTo, HLineTo, LineTo, MoveTo, QuadCurveTo, VLineTo
        *
        * PathElement   setAbsolute(boolean value)  是否使用相对坐标 每个元素都有的
        * */
        Path path = new Path();
        //通过移动到指定的坐标 XY 来创建路径的添加
        MoveTo moveTo = new MoveTo();
        moveTo.setX(0.0f);
        moveTo.setY(0.0f);

        //创建从当前点到x的水平线路径元素
        HLineTo hLineTo = new HLineTo();
        hLineTo.setX(70.0f);

        /*
        创建由两个新点定义的曲线路径元素 通过绘制与当前坐标和指定坐标 ( x  y) 相交的二次贝塞尔曲线 使用指定的点 (controlX controlY) 作为贝塞尔控制点
        * */
        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(120.0f);
        quadCurveTo.setY(60.0f);
        quadCurveTo.setControlX(100.0f);
        quadCurveTo.setControlY(0.0f);

        //通过绘制从当前坐标到新坐标的直线来创建行路径元素
        LineTo lineTo = new LineTo();
        lineTo.setX(175.0f);
        lineTo.setY(55.0f);

        //一个路径元素 它使用指定的半径从先前的坐标到指定的 x 和 y 坐标形成一个弧线
        ArcTo arcTo = new ArcTo();
        arcTo.setX(50.0f);
        arcTo.setY(50.0f);
        arcTo.setRadiusX(50.0f);
        arcTo.setRadiusY(50.0f);

        path.getElements().add(moveTo);
        path.getElements().add(hLineTo);
        path.getElements().add(quadCurveTo);
        path.getElements().add(lineTo);
        path.getElements().add(arcTo);
        path.getElements().add(new ClosePath());
        //定义用于确定路径内部的填充规则常量 该值必须是下列其中一个常量  FillRile.EVEN_ODD 或 FillRule.NON_ZERO 缺省值为 FillRule.NON_ZERO
        path.setFillRule(FillRule.EVEN_ODD);

        path.setStroke(Color.RED);
        path.setStrokeWidth(2);
        path.setFill(Color.BLUE);
        root.getChildren().add(path);
        Scene scene = new Scene(root);
        primaryStage.setTitle("2D游戏 路径 图像绘制");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        System.out.println(path.getLayoutBounds());
        System.out.println(path.getBoundsInLocal());
        System.out.println(path.getBoundsInParent());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

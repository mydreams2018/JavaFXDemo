package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.lang.reflect.Field;

public class SetCellFactory extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox();
        ComboBox<Color> cmb = new ComboBox<>();
        cmb.setEditable(false);
        cmb.getItems().addAll(Color.RED, Color.GREEN, Color.BLUE);
        cmb.getSelectionModel().select(Color.RED);
        //原始设计不是很好
        cmb.setConverter(new StringConverter<Color>() {
            @Override
            public String toString(Color item) {
                if (item != null) {
                    Field[] fields = item.getClass().getFields();
                    for (Field field : fields) {
                        if (field.getType() == Color.class) {
                            try {
                                Color fd = (Color) field.get(null);
                                if (fd == item) {
                                    return field.getName();
                                }
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                return "";
            }

            @Override
            public Color fromString(String string) {
                return null;
            }
        });
        cmb.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
            @Override
            public ListCell<Color> call(ListView<Color> param) {

                return new ListCell<>() {
                    private final Rectangle rectangle;

                    {
                        //Graphic 位置  ContentDisplay.GRAPHIC_ONLY仅图像
                        setContentDisplay(ContentDisplay.LEFT);
                        rectangle = new Rectangle(10, 10);
                    }

                    @Override
                    protected void updateItem(Color item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            rectangle.setFill(item);
                            //有一些组件可以设置这个 类似组件图标的东西
                            setGraphic(rectangle);
                            setText(cmb.getConverter().toString(item));
                        }
                    }
                };
            }
        });
        hbox.getChildren().add(cmb);
        Scene scene = new Scene(hbox);
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

package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class DragAndDrop extends Application {

    final Text source = new Text(50, 100, "DRAG ME");
    final Text target = new Text(300, 100, "DROP HERE");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        source.setOnDragDetected(event -> {
            /* 检测到拖动，启动拖放手势 */
            /* 允许任何传输模式  */
            Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
            /* 把img放在拖板上 */
            ClipboardContent content = new ClipboardContent();
            content.putImage(new Image(new File("F:\\mir\\backItem\\0.png").toURI().toString()));
            db.setContent(content);
            event.consume();
        });
        target.setOnDragOver(event -> {
            /* 数据被拖到目标上 */
            /* 仅当它不是从同一节点拖动时才接受它
             * 如果它有字符串数据 */
            if (event.getGestureSource() != target && event.getDragboard().hasImage()) {
                /* 允许移动 */
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        target.setOnDragEntered(event -> {
            /* 拖放手势进入目标 */
            /* 向用户显示它是一个实际的手势目标 */
            if (event.getGestureSource() != target && event.getDragboard().hasImage()) {
                target.setFill(Color.GREEN);
            }
            event.consume();
        });
        target.setOnDragExited(event -> {
            /* 鼠标移开，删除图形提示 */
            target.setFill(Color.BLACK);
            event.consume();
        });
        target.setOnDragDropped(event -> {
            /* 数据丢下 */
            /* 如果drags board上有字符串数据，请读取并使用它 */
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasImage()) {
                target.setText(db.getImage().toString());
                success = true;
            }
            /* 让源知道字符串是否成功
             * 转换和使用 */
            event.setDropCompleted(success);
            event.consume();
        });
        source.setOnDragDone(event -> {
            /* 拖放手势结束 */
            /* 如果数据已成功移动，请将其清除  */
            if (event.getTransferMode() == TransferMode.MOVE) {
                source.setText("success");
            }
            event.consume();
        });
        Group root = new Group();
        root.getChildren().addAll(source ,target);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("TabPane Demo");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }
}

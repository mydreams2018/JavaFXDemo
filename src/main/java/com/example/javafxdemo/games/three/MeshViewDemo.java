package com.example.javafxdemo.games.three;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.shape.VertexFormat;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class MeshViewDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        TriangleMesh mesh = new TriangleMesh(VertexFormat.POINT_TEXCOORD);
        //矩形的面XY点
        float[] vertices = new float[]{
                0,0,0,
                100,0,0,
                100,100,0,
                0,100,0,

                100,0,100,
                100,100,100,
        };
        //宽高表示0~1
        float[] texCoords = new float[]{
                0,0,
                0.5f,0,
                0.5f,0.5f,
                0,0.5f,
                1,0,
                1,0.5f
        };
        //前二个数据的索引坐标 分割出三角形
        int[] faces = new int[]{
            0,0,1,1,3,3,
            0,0,3,3,1,1,
            1,1,2,2,3,3,
            1,1,3,3,2,2,
            1,1,4,4,5,5,
            1,1,5,5,4,4,
            1,1,2,2,5,5,
            1,1,5,5,2,2
        };
        mesh.getPoints().addAll(vertices);
        mesh.getTexCoords().addAll(texCoords);
        mesh.getFaces().addAll(faces);

        MeshView meshView = new MeshView(mesh);
        meshView.setRotationAxis(Rotate.Y_AXIS);
        meshView.setRotate(30);
        root.getChildren().add(meshView);
        //使用3D效果
        Scene scene = new Scene(root, 800, 800, true);
        PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
        perspectiveCamera.setTranslateZ(-300);
        scene.setCamera(perspectiveCamera);
        primaryStage.setTitle("3D 自定义图形");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

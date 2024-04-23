package com.example.javafxdemo.games.three;

import com.example.javafxdemo.HelloApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class BoxDemo extends Application {


    /*
    * DirectionalLight 从特定方向点亮对象的光  方向由方向向量属性定义
    * DirectionalLights 可以表示强烈的光源 这些光源远远足够它们照射到的物体
    *  它们的光线似乎是平行的 因为这些光源被认为是无穷远的 所以不能衰减 太阳是一个普通的光源 可以用这种光型来模拟
    *
    * */


    private Rotate rotate = new Rotate(0, Rotate.Y_AXIS);
    private int angle = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        for (int i = 0; i < 5; i++) {
            Box box = new Box(100, 100, 200);
            box.setLayoutX(i * 130);
            box.setLayoutY(200);
            if (i % 2 == 0) {
                //线条模式
                box.setDrawMode(DrawMode.LINE);
                //BACK FRONT NONE=全部演染
                box.setCullFace(CullFace.BACK);
            }
            root.getChildren().add(box);
        }
        //圆柱型  divisions 分区的柱面 越多效果越好
        Cylinder cylinder = new Cylinder(25, 100);
        cylinder.setLayoutX(700);
        cylinder.setLayoutY(200);
     /*   表示 3D 表面的材料的基类  材料用于赋予物体逼真的外观 (Shape3D) 对应于织物 金属 塑料 玻璃和木材等物理材料
        每个材料都定义它与光的相互作用 例如它的反射特性赋予它的外观
       请参阅 ConditionalFeature.SCENE3D
        PhongMaterial 材质实现类
        */
        PhongMaterial phongMaterial = new PhongMaterial();
        //漫反射颜色 默认白色
        phongMaterial.setDiffuseColor(Color.YELLOW.darker());
        //漫反射图 phongMaterial.setDiffuseMap()
        //镜面颜色
        phongMaterial.setSpecularColor(Color.WHITE);
        //镜面反射图 phongMaterial.setSpecularMap();
        //镜面反射功率 默认32
        phongMaterial.setSpecularPower(10);
        //凹凸贴图 是存储为RGB Image的法线贴图 [不是普通的图片]
//        phongMaterial.setBumpMap(new Image(""));
        //自发光图 物体本身的光色
        phongMaterial.setSelfIlluminationMap(new Image(HelloApplication.class.getResource("R-C.jpg").toExternalForm()));


        cylinder.setMaterial(phongMaterial);
        cylinder.getTransforms().add(rotate);
        root.getChildren().add(cylinder);
     /*   点光源 它在远离自身的所有方向上均匀地照射光  光源的位置是一个单一的空间 它将通过 constantAttenuation lineartenuation QuadraticAttenation maxRange
         属性进行衰减
         constantAttenuation 恒定衰减系数
         linearAttenuation 线性衰减系数
         maxRange  最大范围 较低的值可以提供更好的性能 因为在光的范围之外的像素不需要复杂的计算 Double.POSITIVE_INFINITY
         quadraticAttenuation 二次衰减系数
         */
        PointLight pointLight = new PointLight();
        pointLight.setColor(Color.GREENYELLOW);
        pointLight.getScope().add(cylinder);
        root.getChildren().add(pointLight);

        //创建具有给定半径和分区数的 越多效果越圆
        Sphere sphere = new Sphere(25, 5);
        sphere.setLayoutX(800);
        sphere.setLayoutY(200);
        root.getChildren().add(sphere);

        //光源 一种光 不管它的位置和方向如何 都能从所有方向照射物体
        AmbientLight ambientLight = new AmbientLight(Color.RED);
        //开启光源
        ambientLight.setLightOn(true);
        //指定使用光源的组件
        ambientLight.getScope().add(sphere);
        //指定排除使用光源的组件 ambientLight.getExclusionScope().add();
        root.getChildren().add(ambientLight);

        Button button = new Button("Click me");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rotate.setAngle(angle+=10);
            }
        });

        button.setLayoutY(300);
        root.getChildren().add(button);

        root.setDepthTest(DepthTest.ENABLE);
//        root.setBackground(Background.EMPTY);
        //使用3D效果
        Scene scene = new Scene(root, 800, 800, true);
        //ParallelCamera  PerspectiveCamera 相机
        PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
        //让相机有一个距离感 要不然最左边的组件会有一部分看不到 太近了
        perspectiveCamera.setTranslateZ(-300);
        //旋转
//        perspectiveCamera.setRotationAxis(Rotate.Y_AXIS);
//        perspectiveCamera.setRotate(50);
        //指定摄像机投影的视场角 以度测量 默认30 越大相当距离越远
        perspectiveCamera.setFieldOfView(30);
        //指定该摄像头在眼睛坐标空间中的近夹平面的距离  未绘制接近眼睛的物体 nearClip 指定为大于零的值  小于或等于零的值被视为非常小的正数 默认0.1
        perspectiveCamera.setNearClip(0.3);
        scene.setCamera(perspectiveCamera);
        primaryStage.setTitle("3D 矩形 Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

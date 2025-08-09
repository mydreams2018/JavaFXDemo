package com.example.javafxdemo.json;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class TreeArea {
    private String title;
    private String id;
    /*
     * xNumber x坐标有几个地图
     * yNumber y坐标有几个地图
     * */
    private Integer xNumber;
    private Integer yNumber;
    private Integer width;
    private Integer height;
    private List<TreeGameMap> childrenMap;
    private String imageDirectory;
    private String[][] childrenPointName;
    private String bgAudioClip;
    /*
     * 区域角色初始的坐标
     * */
    private Integer areaLocatorX;
    private Integer areaLocatorY;

}

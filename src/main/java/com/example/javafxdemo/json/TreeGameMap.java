package com.example.javafxdemo.json;

import cn.kungreat.share.ActionHistory;
import cn.kungreat.share.DirectionHistory;
import cn.kungreat.share.ImageObjectType;
import cn.kungreat.share.MonsterType;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class TreeGameMap {
    private String title;
    private String id;
    private List<BackgroundImageData> backgroundImages;
    private String backgroundImagePath;
    private List<ImageObject> imageObjectList;
    private Integer width;
    private Integer height;

    @Setter
    @Getter
    public static class BackgroundImageData {
        private String imagePath;
        private double startX;
        private double startY;
        //定位XY的索引坐标系
        private Integer locatorX;
        private Integer locatorY;
        private Integer srcLX;
        private Integer srcLY;
        //back = 5 middle = 4 frontTiles = 9  role-monster  front = 3 frontBlend = 2
        private int mirImageMark;
        //使用本地的图片标识
        private Boolean localImage;

        public double getStartX() {
            return Math.floor(startX);
        }

        public double getStartY() {
            return Math.floor(startY);
        }
    }

    @Setter
    @Getter
    public static class ImageObject extends BackgroundImageData {
        private String id;
        private String title;
        private ImageObjectType type;
        private Integer countAllBloodVolume;
        private Integer countAllBlueVolume;
        private Integer countRemainBloodVolume;
        private Integer countRemainBlueVolume;
        private MonsterType monsterType;
        //monster的主索引
        private String animationIndex;
        private List<String> baseAnimationName;
        private DirectionHistory currentDirectionHistory;
        private ActionHistory currentActionHistory;
        private String maxActivityScope;
        private String targetXY;
    }
}

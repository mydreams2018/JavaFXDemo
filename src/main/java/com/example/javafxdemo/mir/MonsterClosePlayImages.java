package com.example.javafxdemo.mir;

import javafx.scene.image.Image;
import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MonsterClosePlayImages {

    //基本的怪物
    private static final int BASE_NUMBER = 224;
    private final String directoryName;
    private final List<Image> allImagesCache;
    private final List<PlacementUtil.RoleImageOffsetXY> allFilesCache;
    //idle
    private final List<Image> idleImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> idleFilesCache = new ArrayList<>(32);
    //walk
    private final List<Image> walkImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> walkFilesCache = new ArrayList<>(48);
    //attack1
    private final List<Image> attackOneImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> attackOneFilesCache = new ArrayList<>(48);
    //受伤
    private final List<Image> hurtImagesCache = new ArrayList<>(16);
    private final List<PlacementUtil.RoleImageOffsetXY> hurtFilesCache = new ArrayList<>(16);
    //death
    private final List<Image> deathImagesCache = new ArrayList<>(80);
    private final List<PlacementUtil.RoleImageOffsetXY> deathFilesCache = new ArrayList<>(80);

    public MonsterClosePlayImages(URL urlDirectory, String directoryName) {
        this.directoryName = directoryName;
        File fileDirectory = new File(urlDirectory.getFile(), directoryName);
        allImagesCache = new ArrayList<>(BASE_NUMBER);
        allFilesCache = new ArrayList<>(BASE_NUMBER);
        for (int i = 0; i < BASE_NUMBER; i++) {
            allImagesCache.add(new Image(fileDirectory.toURI().toString() + i + ".png"));
            PlacementUtil.initRoleManFilesCache(new File(fileDirectory, "Placements/" + i + ".txt"), this.allFilesCache);
        }
    }


    //0-31 idle
    private void initIdleImageCache() {
        for (int i = 0; i <= 31; i++) {
            this.idleImagesCache.add(allImagesCache.get(i));
            this.idleFilesCache.add(allFilesCache.get(i));
        }
    }

    //32-79 walk
    private void initWalkImageCache() {
        for (int i = 32; i <= 79; i++) {
            this.walkImagesCache.add(allImagesCache.get(i));
            this.walkFilesCache.add(allFilesCache.get(i));
        }
    }

    //80-127 attack1
    private void initAttackOneImageCache() {
        for (int i = 80; i <= 127; i++) {
            this.attackOneImagesCache.add(allImagesCache.get(i));
            this.attackOneFilesCache.add(allFilesCache.get(i));
        }
    }

    //128-143 hurt
    private void initHurtImageCache() {
        for (int i = 128; i <= 143; i++) {
            this.hurtImagesCache.add(allImagesCache.get(i));
            this.hurtFilesCache.add(allFilesCache.get(i));
        }
    }

    //144-223 death
    private void initDeathImageCache() {
        for (int i = 144; i <= 223; i++) {
            this.deathImagesCache.add(allImagesCache.get(i));
            this.deathFilesCache.add(allFilesCache.get(i));
        }
    }
}

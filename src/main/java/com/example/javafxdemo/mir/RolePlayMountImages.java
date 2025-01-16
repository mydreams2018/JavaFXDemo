package com.example.javafxdemo.mir;

import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RolePlayMountImages {

    private static final int BASE_NUMBER = 168;
    private final String directoryName;
    private final List<Image> mountImagesCache;
    private final List<PlacementUtil.RoleImageOffsetXY> mountFilesCache;

    //idle
    private final List<Image> idleImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> idleFilesCache = new ArrayList<>(32);
    //walk
    private final List<Image> walkImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> walkFilesCache = new ArrayList<>(48);
    //run
    private final List<Image> runImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> runFilesCache = new ArrayList<>(48);
    //受伤
    private final List<Image> hurtImagesCache = new ArrayList<>(24);
    private final List<PlacementUtil.RoleImageOffsetXY> hurtFilesCache = new ArrayList<>(24);

    public RolePlayMountImages(URL urlDirectory, String directoryName) {
        this.directoryName = directoryName;
        File fileDirectory = new File(urlDirectory.getFile(), directoryName);
        mountImagesCache = new ArrayList<>(BASE_NUMBER);
        mountFilesCache = new ArrayList<>(BASE_NUMBER);
        for (int i = 0; i < BASE_NUMBER; i++) {
            mountImagesCache.add(new Image(fileDirectory.toURI().toString() + i + ".png"));
            PlacementUtil.initRoleManFilesCache(new File(fileDirectory, "Placements/" + i + ".txt"), this.mountFilesCache);
        }
        initIdleImageCache();
        initWalkImageCache();
        initRunImageCache();
        initHurtImageCache();
    }

    //0-31 idle
    private void initIdleImageCache() {
        for (int i = 0; i <= 31; i++) {
            this.idleImagesCache.add(mountImagesCache.get(i));
            this.idleFilesCache.add(mountFilesCache.get(i));
        }
    }

    //32-95 walk
    private void initWalkImageCache() {
        for (int i = 32; i <= 95; i++) {
            this.walkImagesCache.add(mountImagesCache.get(i));
            this.walkFilesCache.add(mountFilesCache.get(i));
        }
    }

    //96-143 run
    private void initRunImageCache() {
        for (int i = 96; i <= 143; i++) {
            this.runImagesCache.add(mountImagesCache.get(i));
            this.runFilesCache.add(mountFilesCache.get(i));
        }
    }

    //144-167 hurt
    private void initHurtImageCache() {
        for (int i = 144; i <= 167; i++) {
            this.hurtImagesCache.add(mountImagesCache.get(i));
            this.hurtFilesCache.add(mountFilesCache.get(i));
        }
    }
}

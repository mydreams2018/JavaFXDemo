package com.example.javafxdemo.mir;

import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RoleBodyGloryImages {

    //Auras身上光环
    private static final int BASE_NUMBER = 401;
    private final String directoryName;
    private final List<Image> gloryImagesCache;
    private final List<PlacementUtil.RoleImageOffsetXY> gloryFilesCache;

    public RoleBodyGloryImages(URL urlDirectory, String directoryName) {
        this.directoryName = directoryName;
        File fileDirectory = new File(urlDirectory.getFile(), directoryName);
        this.gloryImagesCache = new ArrayList<>(BASE_NUMBER);
        this.gloryFilesCache = new ArrayList<>(BASE_NUMBER);
        for (int i = 0; i < BASE_NUMBER; i++) {
            this.gloryImagesCache.add(new Image(fileDirectory.toURI().toString() + i + ".png"));
            PlacementUtil.initRoleManFilesCache(new File(fileDirectory, "Placements/" + i + ".txt"), this.gloryFilesCache);
        }
    }
}

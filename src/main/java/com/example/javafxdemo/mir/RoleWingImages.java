package com.example.javafxdemo.mir;

import javafx.scene.image.Image;
import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Getter
public class RoleWingImages {

    //人物翅膀 身上的光环
    private static final int BASE_NUMBER = 1680;
    private final String directoryName;
    private final List<Image> wingImagesCache;
    private final List<PlacementUtil.RoleImageOffsetXY> wingFilesCache;

    //man idle
    private final List<Image> manIdleImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> manIdleFilesCache = new ArrayList<>(64);
    //man walk
    private final List<Image> manWalkImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> manWalkFilesCache = new ArrayList<>(48);
    //man run
    private final List<Image> manRunImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> manRunFilesCache = new ArrayList<>(48);
    //man 8个方向初始功击图
    private final List<Image> manInitAttackImagesCache = new ArrayList<>(8);
    private final List<PlacementUtil.RoleImageOffsetXY> manInitAttackFilesCache = new ArrayList<>(8);
    //man attack1
    private final List<Image> manAttackOneImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> manAttackOneFilesCache = new ArrayList<>(48);
    //man attack2
    private final List<Image> manAttackTwoImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> manAttackTwoFilesCache = new ArrayList<>(48);
    //man attack3
    private final List<Image> manAttackThreeImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> manAttackThreeFilesCache = new ArrayList<>(64);
    //man magic attack1
    private final List<Image> manMagicAttackOneImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> manMagicAttackOneFilesCache = new ArrayList<>(48);
    //man 挖肉
    private final List<Image> manDiggingMeatImagesCache = new ArrayList<>(16);
    private final List<PlacementUtil.RoleImageOffsetXY> manDiggingMeatFilesCache = new ArrayList<>(16);
    //man 受伤
    private final List<Image> manHurtImagesCache = new ArrayList<>(24);
    private final List<PlacementUtil.RoleImageOffsetXY> manHurtFilesCache = new ArrayList<>(24);
    //man death
    private final List<Image> manDeathImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> manDeathFilesCache = new ArrayList<>(32);
    //man 骑术1 MountStanding
    private final List<Image> manHorseOneImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> manHorseOneFilesCache = new ArrayList<>(32);
    //man 骑术2 MountWalking
    private final List<Image> manHorseTwoImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> manHorseTwoFilesCache = new ArrayList<>(64);
    //man 骑术3 MountRunning
    private final List<Image> manHorseThreeImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> manHorseThreeFilesCache = new ArrayList<>(48);
    //man 骑术受伤 MountStruck
    private final List<Image> manHorseHurtImagesCache = new ArrayList<>(24);
    private final List<PlacementUtil.RoleImageOffsetXY> manHorseHurtFilesCache = new ArrayList<>(24);
    //man 骑术4 Attack
    private final List<Image> manHorseFourImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> manHorseFourFilesCache = new ArrayList<>(48);

    //woman idle
    private final List<Image> womanIdleImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> womanIdleFilesCache = new ArrayList<>(64);
    //woman walk
    private final List<Image> womanWalkImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> womanWalkFilesCache = new ArrayList<>(48);
    //woman run
    private final List<Image> womanRunImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> womanRunFilesCache = new ArrayList<>(48);
    //woman 8个方向初始功击图
    private final List<Image> womanInitAttackImagesCache = new ArrayList<>(8);
    private final List<PlacementUtil.RoleImageOffsetXY> womanInitAttackFilesCache = new ArrayList<>(8);
    //woman attack1
    private final List<Image> womanAttackOneImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> womanAttackOneFilesCache = new ArrayList<>(48);
    //woman attack2
    private final List<Image> womanAttackTwoImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> womanAttackTwoFilesCache = new ArrayList<>(48);
    //woman attack3
    private final List<Image> womanAttackThreeImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> womanAttackThreeFilesCache = new ArrayList<>(64);
    //woman magic attack1
    private final List<Image> womanMagicAttackOneImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> womanMagicAttackOneFilesCache = new ArrayList<>(48);
    //woman 挖肉
    private final List<Image> womanDiggingMeatImagesCache = new ArrayList<>(16);
    private final List<PlacementUtil.RoleImageOffsetXY> womanDiggingMeatFilesCache = new ArrayList<>(16);
    //woman 受伤
    private final List<Image> womanHurtImagesCache = new ArrayList<>(24);
    private final List<PlacementUtil.RoleImageOffsetXY> womanHurtFilesCache = new ArrayList<>(24);
    //woman death
    private final List<Image> womanDeathImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> womanDeathFilesCache = new ArrayList<>(32);
    //woman
    private final List<Image> womanHorseOneImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> womanHorseOneFilesCache = new ArrayList<>(32);
    //woman
    private final List<Image> womanHorseTwoImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> womanHorseTwoFilesCache = new ArrayList<>(64);
    //woman
    private final List<Image> womanHorseThreeImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> womanHorseThreeFilesCache = new ArrayList<>(48);
    //woman 骑术受伤
    private final List<Image> womanHorseHurtImagesCache = new ArrayList<>(24);
    private final List<PlacementUtil.RoleImageOffsetXY> womanHorseHurtFilesCache = new ArrayList<>(24);
    //woman 骑术4 Attack
    private final List<Image> womanHorseFourImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> womanHorseFourFilesCache = new ArrayList<>(48);

    public RoleWingImages(URL urlDirectory, String directoryName) {
        this.directoryName = directoryName;
        File fileDirectory = new File(urlDirectory.getFile(), directoryName);
        this.wingImagesCache = new ArrayList<>(BASE_NUMBER);
        this.wingFilesCache = new ArrayList<>(BASE_NUMBER);
        for (int i = 0; i < BASE_NUMBER; i++) {
            wingImagesCache.add(new Image(fileDirectory.toURI().toString() + i + ".png"));
            PlacementUtil.initRoleManFilesCache(new File(fileDirectory, "Placements/" + i + ".txt"), this.wingFilesCache);
        }
        this.initIdleImageCache();
        this.initWalkImageCache();
        this.initRunImageCache();
        this.initInitAttackImageCache();
        this.initAttackOneImageCache();
        this.initAttackTwoImageCache();
        this.initAttackThreeImageCache();
        this.initMagicAttackOneImageCache();
        this.initDiggingMeatImageCache();
        this.initHurtImageCache();
        this.initDeathImageCache();
        this.initHorseOneImageCache();
        this.initHorseTwoImageCache();
        this.initHorseThreeImageCache();
        this.initHorseHurtImageCache();
        this.initHorseFourImageCache();
    }

    //0-63 idle
    private void initIdleImageCache() {
        for (int i = 0; i <= 63; i++) {
            this.manIdleImagesCache.add(wingImagesCache.get(i));
            this.manIdleFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 840; i <= 63 + 840; i++) {
            this.womanIdleImagesCache.add(wingImagesCache.get(i));
            this.womanIdleFilesCache.add(wingFilesCache.get(i));
        }
    }

    //64-111 walk
    private void initWalkImageCache() {
        for (int i = 64; i <= 111; i++) {
            this.manWalkImagesCache.add(wingImagesCache.get(i));
            this.manWalkFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 64 + 840; i <= 111 + 840; i++) {
            this.womanWalkImagesCache.add(wingImagesCache.get(i));
            this.womanWalkFilesCache.add(wingFilesCache.get(i));
        }
    }

    //112-159 run
    private void initRunImageCache() {
        for (int i = 112; i <= 159; i++) {
            this.manRunImagesCache.add(wingImagesCache.get(i));
            this.manRunFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 112 + 840; i <= 159 + 840; i++) {
            this.womanRunImagesCache.add(wingImagesCache.get(i));
            this.womanRunFilesCache.add(wingFilesCache.get(i));
        }
    }

    //160-167 8个方向初始功击图
    private void initInitAttackImageCache() {
        for (int i = 160; i <= 167; i++) {
            this.manInitAttackImagesCache.add(wingImagesCache.get(i));
            this.manInitAttackFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 160 + 840; i <= 167 + 840; i++) {
            this.womanInitAttackImagesCache.add(wingImagesCache.get(i));
            this.womanInitAttackFilesCache.add(wingFilesCache.get(i));
        }
    }

    //168-215 attack1
    private void initAttackOneImageCache() {
        for (int i = 168; i <= 215; i++) {
            this.manAttackOneImagesCache.add(wingImagesCache.get(i));
            this.manAttackOneFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 168 + 840; i <= 215 + 840; i++) {
            this.womanAttackOneImagesCache.add(wingImagesCache.get(i));
            this.womanAttackOneFilesCache.add(wingFilesCache.get(i));
        }
    }

    //216-263 attack2
    private void initAttackTwoImageCache() {
        for (int i = 216; i <= 263; i++) {
            this.manAttackTwoImagesCache.add(wingImagesCache.get(i));
            this.manAttackTwoFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 216 + 840; i <= 263 + 840; i++) {
            this.womanAttackTwoImagesCache.add(wingImagesCache.get(i));
            this.womanAttackTwoFilesCache.add(wingFilesCache.get(i));
        }
    }

    //264-327 attack3
    private void initAttackThreeImageCache() {
        for (int i = 264; i <= 327; i++) {
            this.manAttackThreeImagesCache.add(wingImagesCache.get(i));
            this.manAttackThreeFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 264 + 840; i <= 327 + 840; i++) {
            this.womanAttackThreeImagesCache.add(wingImagesCache.get(i));
            this.womanAttackThreeFilesCache.add(wingFilesCache.get(i));
        }
    }

    //328-375 magic attack1
    private void initMagicAttackOneImageCache() {
        for (int i = 328; i <= 375; i++) {
            this.manMagicAttackOneImagesCache.add(wingImagesCache.get(i));
            this.manMagicAttackOneFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 328 + 840; i <= 375 + 840; i++) {
            this.womanMagicAttackOneImagesCache.add(wingImagesCache.get(i));
            this.womanMagicAttackOneFilesCache.add(wingFilesCache.get(i));
        }
    }

    //376-391 挖肉
    private void initDiggingMeatImageCache() {
        for (int i = 376; i <= 391; i++) {
            this.manDiggingMeatImagesCache.add(wingImagesCache.get(i));
            this.manDiggingMeatFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 376 + 840; i <= 391 + 840; i++) {
            this.womanDiggingMeatImagesCache.add(wingImagesCache.get(i));
            this.womanDiggingMeatFilesCache.add(wingFilesCache.get(i));
        }
    }

    //392-415 hurt
    private void initHurtImageCache() {
        for (int i = 392; i <= 415; i++) {
            this.manHurtImagesCache.add(wingImagesCache.get(i));
            this.manHurtFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 392 + 840; i <= 415 + 840; i++) {
            this.womanHurtImagesCache.add(wingImagesCache.get(i));
            this.womanHurtFilesCache.add(wingFilesCache.get(i));
        }
    }

    //416-447 death
    private void initDeathImageCache() {
        for (int i = 416; i <= 447; i++) {
            this.manDeathImagesCache.add(wingImagesCache.get(i));
            this.manDeathFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 416 + 840; i <= 447 + 840; i++) {
            this.womanDeathImagesCache.add(wingImagesCache.get(i));
            this.womanDeathFilesCache.add(wingFilesCache.get(i));
        }
    }

    //448-479 骑术1
    private void initHorseOneImageCache() {
        for (int i = 448; i <= 479; i++) {
            this.manHorseOneImagesCache.add(wingImagesCache.get(i));
            this.manHorseOneFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 448 + 840; i <= 479 + 840; i++) {
            this.womanHorseOneImagesCache.add(wingImagesCache.get(i));
            this.womanHorseOneFilesCache.add(wingFilesCache.get(i));
        }
    }

    //480-543 骑术2
    private void initHorseTwoImageCache() {
        for (int i = 480; i <= 543; i++) {
            this.manHorseTwoImagesCache.add(wingImagesCache.get(i));
            this.manHorseTwoFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 480 + 840; i <= 543 + 840; i++) {
            this.womanHorseTwoImagesCache.add(wingImagesCache.get(i));
            this.womanHorseTwoFilesCache.add(wingFilesCache.get(i));
        }
    }

    //544-591 骑术3
    private void initHorseThreeImageCache() {
        for (int i = 544; i <= 591; i++) {
            this.manHorseThreeImagesCache.add(wingImagesCache.get(i));
            this.manHorseThreeFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 544 + 840; i <= 591 + 840; i++) {
            this.womanHorseThreeImagesCache.add(wingImagesCache.get(i));
            this.womanHorseThreeFilesCache.add(wingFilesCache.get(i));
        }
    }

    //592-615 骑术受伤
    private void initHorseHurtImageCache() {
        for (int i = 592; i <= 615; i++) {
            this.manHorseHurtImagesCache.add(wingImagesCache.get(i));
            this.manHorseHurtFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 592 + 840; i <= 615 + 840; i++) {
            this.womanHorseHurtImagesCache.add(wingImagesCache.get(i));
            this.womanHorseHurtFilesCache.add(wingFilesCache.get(i));
        }
    }

    //616-663 骑术4
    private void initHorseFourImageCache() {
        for (int i = 616; i <= 663; i++) {
            this.manHorseFourImagesCache.add(wingImagesCache.get(i));
            this.manHorseFourFilesCache.add(wingFilesCache.get(i));
        }
        for (int i = 616 + 840; i <= 663 + 840; i++) {
            this.womanHorseFourImagesCache.add(wingImagesCache.get(i));
            this.womanHorseFourFilesCache.add(wingFilesCache.get(i));
        }
    }
}

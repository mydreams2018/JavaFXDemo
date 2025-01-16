package com.example.javafxdemo.mir;

import javafx.scene.image.Image;
import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Getter
public class RolePlayHairImages {

    private static final int BASE_NUMBER = 1616;
    private final String directoryName;
    private final List<Image> allImagesCache;
    private final List<PlacementUtil.RoleImageOffsetXY> allFilesCache;
    //man idle
    private final List<Image> manIdleImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> manIdleFilesCache = new ArrayList<>(32);
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
    //man 钓鱼
    private final List<Image> manFishingCastImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> manFishingCastFilesCache = new ArrayList<>(64);
    //man 钓鱼等待
    private final List<Image> manFishingWaitImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> manFishingWaitFilesCache = new ArrayList<>(48);
    //man 渔线轮
    private final List<Image> manFishingReelImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> manFishingReelFilesCache = new ArrayList<>(64);

    //woman idle
    private final List<Image> womanIdleImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> womanIdleFilesCache = new ArrayList<>(32);
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
    //woman
    private final List<Image> womanFishingCastImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> womanFishingCastFilesCache = new ArrayList<>(64);
    //woman
    private final List<Image> womanFishingWaitImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> womanFishingWaitFilesCache = new ArrayList<>(48);
    //woman
    private final List<Image> womanFishingReelImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> womanFishingReelFilesCache = new ArrayList<>(64);

    public RolePlayHairImages(URL urlDirectory, String directoryName) {
        this.directoryName = directoryName;
        File fileDirectory = new File(urlDirectory.getFile(), directoryName);
        allImagesCache = new ArrayList<>(BASE_NUMBER);
        allFilesCache = new ArrayList<>(BASE_NUMBER);
        for (int i = 0; i < BASE_NUMBER; i++) {
            allImagesCache.add(new Image(fileDirectory.toURI().toString() + i + ".png"));
            PlacementUtil.initRoleManFilesCache(new File(fileDirectory, "Placements/" + i + ".txt"), this.allFilesCache);
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
        this.initFishingCastImageCache();
        this.initFishingWaitImageCache();
        this.initFishingReelImageCache();
    }

    //0-31 idle
    private void initIdleImageCache() {
        for (int i = 0; i <= 31; i++) {
            this.manIdleImagesCache.add(allImagesCache.get(i));
            this.manIdleFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 808; i <= 31 + 808; i++) {
            this.womanIdleImagesCache.add(allImagesCache.get(i));
            this.womanIdleFilesCache.add(allFilesCache.get(i));
        }
    }

    //32-79 walk
    private void initWalkImageCache() {
        for (int i = 32; i <= 79; i++) {
            this.manWalkImagesCache.add(allImagesCache.get(i));
            this.manWalkFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 32 + 808; i <= 79 + 808; i++) {
            this.womanWalkImagesCache.add(allImagesCache.get(i));
            this.womanWalkFilesCache.add(allFilesCache.get(i));
        }
    }

    //80-127 run
    private void initRunImageCache() {
        for (int i = 80; i <= 127; i++) {
            this.manRunImagesCache.add(allImagesCache.get(i));
            this.manRunFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 80 + 808; i <= 127 + 808; i++) {
            this.womanRunImagesCache.add(allImagesCache.get(i));
            this.womanRunFilesCache.add(allFilesCache.get(i));
        }
    }

    //128-135 8个方向初始功击图
    private void initInitAttackImageCache() {
        for (int i = 128; i <= 135; i++) {
            this.manInitAttackImagesCache.add(allImagesCache.get(i));
            this.manInitAttackFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 128 + 808; i <= 135 + 808; i++) {
            this.womanInitAttackImagesCache.add(allImagesCache.get(i));
            this.womanInitAttackFilesCache.add(allFilesCache.get(i));
        }
    }

    //136-183 attack1
    private void initAttackOneImageCache() {
        for (int i = 136; i <= 183; i++) {
            this.manAttackOneImagesCache.add(allImagesCache.get(i));
            this.manAttackOneFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 136 + 808; i <= 183 + 808; i++) {
            this.womanAttackOneImagesCache.add(allImagesCache.get(i));
            this.womanAttackOneFilesCache.add(allFilesCache.get(i));
        }
    }

    //184-231 attack2
    private void initAttackTwoImageCache() {
        for (int i = 184; i <= 231; i++) {
            this.manAttackTwoImagesCache.add(allImagesCache.get(i));
            this.manAttackTwoFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 184 + 808; i <= 231 + 808; i++) {
            this.womanAttackTwoImagesCache.add(allImagesCache.get(i));
            this.womanAttackTwoFilesCache.add(allFilesCache.get(i));
        }
    }

    //232-295 attack3
    private void initAttackThreeImageCache() {
        for (int i = 232; i <= 295; i++) {
            this.manAttackThreeImagesCache.add(allImagesCache.get(i));
            this.manAttackThreeFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 232 + 808; i <= 295 + 808; i++) {
            this.womanAttackThreeImagesCache.add(allImagesCache.get(i));
            this.womanAttackThreeFilesCache.add(allFilesCache.get(i));
        }
    }

    //296-343 magic attack1
    private void initMagicAttackOneImageCache() {
        for (int i = 296; i <= 343; i++) {
            this.manMagicAttackOneImagesCache.add(allImagesCache.get(i));
            this.manMagicAttackOneFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 296 + 808; i <= 343 + 808; i++) {
            this.womanMagicAttackOneImagesCache.add(allImagesCache.get(i));
            this.womanMagicAttackOneFilesCache.add(allFilesCache.get(i));
        }
    }

    //344-359 挖肉
    private void initDiggingMeatImageCache() {
        for (int i = 344; i <= 359; i++) {
            this.manDiggingMeatImagesCache.add(allImagesCache.get(i));
            this.manDiggingMeatFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 344 + 808; i <= 359 + 808; i++) {
            this.womanDiggingMeatImagesCache.add(allImagesCache.get(i));
            this.womanDiggingMeatFilesCache.add(allFilesCache.get(i));
        }
    }

    //360-383 hurt
    private void initHurtImageCache() {
        for (int i = 360; i <= 383; i++) {
            this.manHurtImagesCache.add(allImagesCache.get(i));
            this.manHurtFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 360 + 808; i <= 383 + 808; i++) {
            this.womanHurtImagesCache.add(allImagesCache.get(i));
            this.womanHurtFilesCache.add(allFilesCache.get(i));
        }
    }

    //384-415 death
    private void initDeathImageCache() {
        for (int i = 384; i <= 415; i++) {
            this.manDeathImagesCache.add(allImagesCache.get(i));
            this.manDeathFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 384 + 808; i <= 415 + 808; i++) {
            this.womanDeathImagesCache.add(allImagesCache.get(i));
            this.womanDeathFilesCache.add(allFilesCache.get(i));
        }
    }

    //416-447 骑术1
    private void initHorseOneImageCache() {
        for (int i = 416; i <= 447; i++) {
            this.manHorseOneImagesCache.add(allImagesCache.get(i));
            this.manHorseOneFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 416 + 808; i <= 447 + 808; i++) {
            this.womanHorseOneImagesCache.add(allImagesCache.get(i));
            this.womanHorseOneFilesCache.add(allFilesCache.get(i));
        }
    }

    //448-511 骑术2
    private void initHorseTwoImageCache() {
        for (int i = 448; i <= 511; i++) {
            this.manHorseTwoImagesCache.add(allImagesCache.get(i));
            this.manHorseTwoFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 448 + 808; i <= 511 + 808; i++) {
            this.womanHorseTwoImagesCache.add(allImagesCache.get(i));
            this.womanHorseTwoFilesCache.add(allFilesCache.get(i));
        }
    }

    //512-559 骑术3
    private void initHorseThreeImageCache() {
        for (int i = 512; i <= 559; i++) {
            this.manHorseThreeImagesCache.add(allImagesCache.get(i));
            this.manHorseThreeFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 512 + 808; i <= 559 + 808; i++) {
            this.womanHorseThreeImagesCache.add(allImagesCache.get(i));
            this.womanHorseThreeFilesCache.add(allFilesCache.get(i));
        }
    }

    //560-583 骑术受伤
    private void initHorseHurtImageCache() {
        for (int i = 560; i <= 583; i++) {
            this.manHorseHurtImagesCache.add(allImagesCache.get(i));
            this.manHorseHurtFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 560 + 808; i <= 583 + 808; i++) {
            this.womanHorseHurtImagesCache.add(allImagesCache.get(i));
            this.womanHorseHurtFilesCache.add(allFilesCache.get(i));
        }
    }

    //584-631 骑术4
    private void initHorseFourImageCache() {
        for (int i = 584; i <= 631; i++) {
            this.manHorseFourImagesCache.add(allImagesCache.get(i));
            this.manHorseFourFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 584 + 808; i <= 631 + 808; i++) {
            this.womanHorseFourImagesCache.add(allImagesCache.get(i));
            this.womanHorseFourFilesCache.add(allFilesCache.get(i));
        }
    }

    //632-695
    private void initFishingCastImageCache() {
        for (int i = 632; i <= 695; i++) {
            this.manFishingCastImagesCache.add(allImagesCache.get(i));
            this.manFishingCastFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 632 + 808; i <= 695 + 808; i++) {
            this.womanFishingCastImagesCache.add(allImagesCache.get(i));
            this.womanFishingCastFilesCache.add(allFilesCache.get(i));
        }
    }

    //696-743
    private void initFishingWaitImageCache() {
        for (int i = 696; i <= 743; i++) {
            this.manFishingWaitImagesCache.add(allImagesCache.get(i));
            this.manFishingWaitFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 696 + 808; i <= 743 + 808; i++) {
            this.womanFishingWaitImagesCache.add(allImagesCache.get(i));
            this.womanFishingWaitFilesCache.add(allFilesCache.get(i));
        }
    }

    //744-807
    private void initFishingReelImageCache() {
        for (int i = 744; i <= 807; i++) {
            this.manFishingReelImagesCache.add(allImagesCache.get(i));
            this.manFishingReelFilesCache.add(allFilesCache.get(i));
        }
        for (int i = 744 + 808; i <= 807 + 808; i++) {
            this.womanFishingReelImagesCache.add(allImagesCache.get(i));
            this.womanFishingReelFilesCache.add(allFilesCache.get(i));
        }
    }
}

package com.example.javafxdemo.mir;

import javafx.scene.image.Image;
import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Getter
public class RoleWeaponEffectImages {

    private static final int BASE_NUMBER = 832;
    private final String directoryName;
    private final List<Image> weaponImagesCache;
    private final List<PlacementUtil.RoleImageOffsetXY> weaponFilesCache;
    //idle
    private final List<Image> idleImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> idleFilesCache = new ArrayList<>(32);
    //walk
    private final List<Image> walkImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> walkFilesCache = new ArrayList<>(48);
    //run
    private final List<Image> runImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> runFilesCache = new ArrayList<>(48);
    //8个方向初始功击图
    private final List<Image> initAttackImagesCache = new ArrayList<>(8);
    private final List<PlacementUtil.RoleImageOffsetXY> initAttackFilesCache = new ArrayList<>(8);
    //attack1
    private final List<Image> attackOneImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> attackOneFilesCache = new ArrayList<>(48);
    //attack2
    private final List<Image> attackTwoImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> attackTwoFilesCache = new ArrayList<>(48);
    //attack3
    private final List<Image> attackThreeImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> attackThreeFilesCache = new ArrayList<>(64);
    //magic attack1
    private final List<Image> magicAttackOneImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> magicAttackOneFilesCache = new ArrayList<>(48);
    //挖肉
    private final List<Image> diggingMeatImagesCache = new ArrayList<>(16);
    private final List<PlacementUtil.RoleImageOffsetXY> diggingMeatFilesCache = new ArrayList<>(16);
    //受伤
    private final List<Image> hurtImagesCache = new ArrayList<>(24);
    private final List<PlacementUtil.RoleImageOffsetXY> hurtFilesCache = new ArrayList<>(24);
    //death
    private final List<Image> deathImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> deathFilesCache = new ArrayList<>(32);
    //骑术1 MountStanding
    private final List<Image> horseOneImagesCache = new ArrayList<>(32);
    private final List<PlacementUtil.RoleImageOffsetXY> horseOneFilesCache = new ArrayList<>(32);
    //骑术2 MountWalking
    private final List<Image> horseTwoImagesCache = new ArrayList<>(64);
    private final List<PlacementUtil.RoleImageOffsetXY> horseTwoFilesCache = new ArrayList<>(64);
    //骑术3 MountRunning
    private final List<Image> horseThreeImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> horseThreeFilesCache = new ArrayList<>(48);
    //骑术受伤 MountStruck
    private final List<Image> horseHurtImagesCache = new ArrayList<>(24);
    private final List<PlacementUtil.RoleImageOffsetXY> horseHurtFilesCache = new ArrayList<>(24);
    //骑术4 Attack
    private final List<Image> horseFourImagesCache = new ArrayList<>(48);
    private final List<PlacementUtil.RoleImageOffsetXY> horseFourFilesCache = new ArrayList<>(48);

    public RoleWeaponEffectImages(URL urlDirectory, String directoryName) {
        this.directoryName = directoryName;
        File fileDirectory = new File(urlDirectory.getFile(), directoryName);
        this.weaponImagesCache = new ArrayList<>(BASE_NUMBER);
        this.weaponFilesCache = new ArrayList<>(BASE_NUMBER);
        for (int i = 0; i < BASE_NUMBER; i++) {
            this.weaponImagesCache.add(new Image(fileDirectory.toURI().toString() + i + ".png"));
            PlacementUtil.initRoleManFilesCache(new File(fileDirectory, "Placements/" + i + ".txt"), this.weaponFilesCache);
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

    //0-31 idle
    private void initIdleImageCache() {
        for (int i = 0; i <= 31; i++) {
            this.idleImagesCache.add(weaponImagesCache.get(i));
            this.idleFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //32-79 walk
    private void initWalkImageCache() {
        for (int i = 32; i <= 79; i++) {
            this.walkImagesCache.add(weaponImagesCache.get(i));
            this.walkFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //80-127 run
    private void initRunImageCache() {
        for (int i = 80; i <= 127; i++) {
            this.runImagesCache.add(weaponImagesCache.get(i));
            this.runFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //128-135 8个方向初始功击图
    private void initInitAttackImageCache() {
        for (int i = 128; i <= 135; i++) {
            this.initAttackImagesCache.add(weaponImagesCache.get(i));
            this.initAttackFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //136-183 attack1
    private void initAttackOneImageCache() {
        for (int i = 136; i <= 183; i++) {
            this.attackOneImagesCache.add(weaponImagesCache.get(i));
            this.attackOneFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //184-231 attack2
    private void initAttackTwoImageCache() {
        for (int i = 184; i <= 231; i++) {
            this.attackTwoImagesCache.add(weaponImagesCache.get(i));
            this.attackTwoFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //232-295 attack3
    private void initAttackThreeImageCache() {
        for (int i = 232; i <= 295; i++) {
            this.attackThreeImagesCache.add(weaponImagesCache.get(i));
            this.attackThreeFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //296-343 magic attack1
    private void initMagicAttackOneImageCache() {
        for (int i = 296; i <= 343; i++) {
            this.magicAttackOneImagesCache.add(weaponImagesCache.get(i));
            this.magicAttackOneFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //344-359 挖肉
    private void initDiggingMeatImageCache() {
        for (int i = 344; i <= 359; i++) {
            this.diggingMeatImagesCache.add(weaponImagesCache.get(i));
            this.diggingMeatFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //360-383 hurt
    private void initHurtImageCache() {
        for (int i = 360; i <= 383; i++) {
            this.hurtImagesCache.add(weaponImagesCache.get(i));
            this.hurtFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //384-415 death
    private void initDeathImageCache() {
        for (int i = 384; i <= 415; i++) {
            this.deathImagesCache.add(weaponImagesCache.get(i));
            this.deathFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //416-447 骑术1
    private void initHorseOneImageCache() {
        for (int i = 416; i <= 447; i++) {
            this.horseOneImagesCache.add(weaponImagesCache.get(i));
            this.horseOneFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //448-511 骑术2
    private void initHorseTwoImageCache() {
        for (int i = 448; i <= 511; i++) {
            this.horseTwoImagesCache.add(weaponImagesCache.get(i));
            this.horseTwoFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //512-559 骑术3
    private void initHorseThreeImageCache() {
        for (int i = 512; i <= 559; i++) {
            this.horseThreeImagesCache.add(weaponImagesCache.get(i));
            this.horseThreeFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //560-583 骑术受伤
    private void initHorseHurtImageCache() {
        for (int i = 560; i <= 583; i++) {
            this.horseHurtImagesCache.add(weaponImagesCache.get(i));
            this.horseHurtFilesCache.add(weaponFilesCache.get(i));
        }
    }

    //584-631 骑术4
    private void initHorseFourImageCache() {
        for (int i = 584; i <= 631; i++) {
            this.horseFourImagesCache.add(weaponImagesCache.get(i));
            this.horseFourFilesCache.add(weaponFilesCache.get(i));
        }
    }
}

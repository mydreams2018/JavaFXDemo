package com.example.javafxdemo.json;

import cn.kungreat.share.ImageObjectType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class JsonFilterSave {

    public static final ObjectMapper MAP_JSON = new ObjectMapper();

    static {
        //遇到空对象时不会抛出异常而是序列化为{}
        MAP_JSON.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAP_JSON.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAP_JSON.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    }

    static String[] mirDirPath = new String[]{"PeachGarden", "Zhongzhou", "Tucheng", "Shacheng", "Mengzhong", "ChiyueValley", "ImperialPalace","ImperialPalacePK",
            "MineHole1", "MineHole2", "MineHole3", "MineHole4", "MineHole5", "MineHole6", "MineHole7", "MineHole8",
            "BoneDemonCave1", "BoneDemonCave2", "BoneDemonCave3", "BoneDemonCave4", "BoneDemonCave5", "BoneDemonCave6",
            "BlackCave1", "BlackCave2", "BlackCave3", "BlackCave4", "BullDemonCave1", "BullDemonCave2", "BullDemonCave3", "BullDemonCave4",
            "WomaTemple1", "WomaTemple2", "WomaTemple3", "WomaTemple4", "CentipedeCave1", "CentipedeCave2", "CentipedeCave3", "CentipedeCave4", "CentipedeCave5", "CentipedeCave6",
            "Pighole1", "Pighole2", "Pighole3", "Pighole4", "Pighole5", "Pighole6", "ZumaTemple1", "ZumaTemple2", "ZumaTemple3", "ZumaTemple4", "ZumaTemple5", "ZumaTemple6",
            "OrcCave1", "OrcCave2", "OrcCave3", "OrcCave4"};

    //服务端用清理不要的 背景图片json数据
    public static void main(String[] args) throws IOException {
        writeClientJsonSingle("F:/mir/mirBrother/ImperialPalacePK");
        writeServerJsonSingle("F:/mir/mirBrother/ImperialPalacePK");
    }

    //服务端json
    public static void writeServerJson(String mirDir) throws IOException {
        for (String childDir : mirDirPath) {
            File srcFile = new File(mirDir, childDir + "/area.json");
            File tarFile = new File(mirDir, childDir + "/serverArea.json");
            TreeArea treeArea = MAP_JSON.readValue(srcFile, TreeArea.class);
            for (TreeGameMap treeGameMap : treeArea.getChildrenMap()) {
                treeGameMap.setBackgroundImages(null);
                List<TreeGameMap.ImageObject> imageObjectList = treeGameMap.getImageObjectList();
                if (imageObjectList != null) {
                    //服务端不需要这个
                    imageObjectList.removeIf(imo -> imo.getType() == ImageObjectType.NPC || imo.getType() == ImageObjectType.FIXED_ANIMATION);
                }
            }
            Files.write(tarFile.toPath(), MAP_JSON.writeValueAsBytes(treeArea));
        }
    }

    public static void writeServerJsonSingle(String mirDir) throws IOException {
        File srcFile = new File(mirDir, "/area.json");
        File tarFile = new File(mirDir, "/serverArea.json");
        TreeArea treeArea = MAP_JSON.readValue(srcFile, TreeArea.class);
        for (TreeGameMap treeGameMap : treeArea.getChildrenMap()) {
            treeGameMap.setBackgroundImages(null);
            List<TreeGameMap.ImageObject> imageObjectList = treeGameMap.getImageObjectList();
            if (imageObjectList != null) {
                //服务端不需要这个
                imageObjectList.removeIf(imo -> imo.getType() == ImageObjectType.NPC || imo.getType() == ImageObjectType.FIXED_ANIMATION);
            }
        }
        Files.write(tarFile.toPath(), MAP_JSON.writeValueAsBytes(treeArea));
    }


    //客户端json
    public static void writeClientJson(String mirDir) throws IOException {
        for (String childDir : mirDirPath) {
            File srcFile = new File(mirDir, childDir + "/area.json");
            File tarFile = new File(mirDir, childDir + "/clientArea.json");
            TreeArea treeArea = MAP_JSON.readValue(srcFile, TreeArea.class);
            for (TreeGameMap treeGameMap : treeArea.getChildrenMap()) {
                List<TreeGameMap.ImageObject> imageObjectList = treeGameMap.getImageObjectList();
                if (imageObjectList != null) {
                    imageObjectList.removeIf(imageObject -> imageObject.getType() == ImageObjectType.MONSTER);
                }
                treeGameMap.getBackgroundImages().forEach(imageObject -> {
                    File localFile = new File(mirDir, childDir + "/" + imageObject.getImagePath());
                    if (localFile.exists()) {
                        imageObject.setLocalImage(true);//使用本地的图片标识
                    }
                });
            }
            Files.write(tarFile.toPath(), MAP_JSON.writeValueAsBytes(treeArea));
        }
    }

    //客户端json
    public static void writeClientJsonSingle(String mirDir) throws IOException {
        File srcFile = new File(mirDir, "area.json");
        File tarFile = new File(mirDir, "clientArea.json");
        TreeArea treeArea = MAP_JSON.readValue(srcFile, TreeArea.class);
        for (TreeGameMap treeGameMap : treeArea.getChildrenMap()) {
            List<TreeGameMap.ImageObject> imageObjectList = treeGameMap.getImageObjectList();
            if (imageObjectList != null) {
                imageObjectList.removeIf(imageObject -> imageObject.getType() == ImageObjectType.MONSTER);
            }
            treeGameMap.getBackgroundImages().forEach(imageObject -> {
                File localFile = new File(mirDir, imageObject.getImagePath());
                if (localFile.exists()) {
                    imageObject.setLocalImage(true);//使用本地的图片标识
                }
            });
        }
        Files.write(tarFile.toPath(), MAP_JSON.writeValueAsBytes(treeArea));
    }

    //一半的几率删除指定的怪物(一些怪物类型生成的过多的情况)
    public static void deleteSrcMonsterSingle(String mirDir, List<String> monsterIndex) throws IOException {
        Random random = new Random();
        File srcFile = new File(mirDir, "area.json");
        TreeArea treeArea = MAP_JSON.readValue(srcFile, TreeArea.class);
        for (TreeGameMap treeGameMap : treeArea.getChildrenMap()) {
            List<TreeGameMap.ImageObject> imageObjectList = treeGameMap.getImageObjectList();
            if (imageObjectList != null) {
                imageObjectList.removeIf(imageObject -> imageObject.getType() == ImageObjectType.MONSTER
                        && monsterIndex.contains(imageObject.getAnimationIndex()) && random.nextBoolean());
            }
        }
        Files.write(srcFile.toPath(), MAP_JSON.writeValueAsBytes(treeArea));
    }

    //随机删除一半的怪
    public static void deleteSrcMonsterSingle(String mirDir) throws IOException {
        Random random = new Random();
        File srcFile = new File(mirDir, "area.json");
        TreeArea treeArea = MAP_JSON.readValue(srcFile, TreeArea.class);
        for (TreeGameMap treeGameMap : treeArea.getChildrenMap()) {
            List<TreeGameMap.ImageObject> imageObjectList = treeGameMap.getImageObjectList();
            if (imageObjectList != null) {
                imageObjectList.removeIf(imageObject -> imageObject.getType() == ImageObjectType.MONSTER && random.nextBoolean());
            }
        }
        Files.write(srcFile.toPath(), MAP_JSON.writeValueAsBytes(treeArea));
    }
}

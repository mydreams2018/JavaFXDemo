package com.example.javafxdemo.mir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public final class PlacementUtil {

    public static void initRoleManFilesCache(File placementFile, List<RoleImageOffsetXY> manFilesCache) {
        try (BufferedReader inReader = new BufferedReader(new FileReader(placementFile))) {
            RoleImageOffsetXY roleImageOffsetXY = new RoleImageOffsetXY(Integer.parseInt(inReader.readLine()), Integer.parseInt(inReader.readLine()));
            manFilesCache.add(roleImageOffsetXY);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static final record RoleImageOffsetXY(int offsetX, int offsetY) {}
}

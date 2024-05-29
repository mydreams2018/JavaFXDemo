package com.example.javafxdemo;

import javafx.geometry.Bounds;
import javafx.scene.Node;

public class CollisionDetection {
    /*
     * mainNode 主节点不要旋转或者 90度的倍数
     * otherNode 任意旋转角度
     * */
    public static boolean checkCollision(Node mainNode, Node otherNode) {
        Bounds mainNodeBounds = mainNode.getBoundsInParent();
        Bounds otherNodeBounds = otherNode.getBoundsInParent();
        if (otherNodeBounds.getMaxX() < mainNodeBounds.getMinX() || otherNodeBounds.getMaxY() < mainNodeBounds.getMinY() ||
                mainNodeBounds.getMaxX() < otherNodeBounds.getMinX() || mainNodeBounds.getMaxY() < otherNodeBounds.getMinY()) {
            return false;
        }
        return true;
    }

    /*
     * 找到交互的起始点XY宽高
     * */
    private static int[] findMutualPoints(Node mainNode, Node otherNode) {
        final int[] points = new int[4];
        Bounds mainNodeBounds = mainNode.getBoundsInParent();
        Bounds otherNodeBounds = otherNode.getBoundsInParent();
        //找到起始点X然后计算出宽度
        if (mainNodeBounds.getMinX() < otherNodeBounds.getMinX()) {
            points[0] = (int) otherNodeBounds.getMinX();
            if (otherNodeBounds.getMaxX() > mainNodeBounds.getMaxX()) {
                points[2] = (int) (mainNodeBounds.getWidth() - (otherNodeBounds.getMinX() - mainNodeBounds.getMinX()));
            } else {
                points[2] = (int) otherNodeBounds.getWidth();
            }
        } else {
            points[0] = (int) mainNodeBounds.getMinX();
            if (otherNodeBounds.getMaxX() > mainNodeBounds.getMaxX()) {
                points[2] = (int) mainNodeBounds.getWidth();
            } else {
                points[2] = (int) (mainNodeBounds.getWidth() - (mainNodeBounds.getMaxX() - otherNodeBounds.getMaxX()));
            }
        }
        //找到起始点Y然后计算出高度
        if (mainNodeBounds.getMinY() < otherNodeBounds.getMinY()) {
            points[1] = (int) otherNodeBounds.getMinY();
            if (otherNodeBounds.getMaxY() > mainNodeBounds.getMaxY()) {
                points[3] = (int) (mainNodeBounds.getHeight() - (otherNodeBounds.getMinY() - mainNodeBounds.getMinY()));
            } else {
                points[3] = (int) otherNodeBounds.getHeight();
            }
        } else {
            points[1] = (int) mainNodeBounds.getMinY();
            if (otherNodeBounds.getMaxY() > mainNodeBounds.getMaxY()) {
                points[3] = (int) mainNodeBounds.getHeight();
            } else {
                points[3] = (int) (mainNodeBounds.getHeight() - (mainNodeBounds.getMaxY() - otherNodeBounds.getMaxY()));
            }
        }
        return points;
    }


    public static boolean isCollision(Node mainNode, Node otherNode) {
        int[] mutualPoints = findMutualPoints(mainNode, otherNode);
        return checkRotateCollision(mutualPoints, otherNode);
    }

    private static boolean checkRotateCollision(int[] mutualPoints, Node mainNode) {
        double rotate = mainNode.getRotate() % 90;
        if (rotate == 0) {
            return true;
        }
        int normalWidth;
        if (isEven((int) (mainNode.getRotate() / 90))) {
            normalWidth = (int) mainNode.getBoundsInLocal().getWidth();
        } else {
            normalWidth = (int) mainNode.getBoundsInLocal().getHeight();
        }
        Bounds boundsInParent = mainNode.getBoundsInParent();
        double cos = Math.cos(2 * Math.PI / 360 * rotate);
        double cosAnother = Math.cos(2 * Math.PI / 360 * (90 - rotate));
        int leftY = (int) (cos * normalWidth);
        int topX = (int) (cosAnother * normalWidth);
        int rightY = (int) boundsInParent.getHeight() - leftY;
        int bottomX = (int) boundsInParent.getWidth() - topX;
        double tempCos, tempCosAnother;
        //上X轴判断
        if (boundsInParent.getMinY() + leftY < mutualPoints[1]) {
            tempCos = cosAnother;
        } else {
            tempCos = cos;
        }
        if (boundsInParent.getMinY() + rightY < mutualPoints[1]) {
            tempCosAnother = cos;
        } else {
            tempCosAnother = cosAnother;
        }
        int tempHeight = Math.max((int) Math.abs(mutualPoints[1] - (boundsInParent.getMinY() + leftY)), 2);
        int tempHeightRight = Math.max((int) Math.abs(mutualPoints[1] - (boundsInParent.getMinY() + rightY)), 2);
        if (checkXCollision(mutualPoints, boundsInParent, tempCos, tempCosAnother, tempHeight, tempHeightRight))
            return true;
        //下X轴判断
        if (boundsInParent.getMinY() + leftY < mutualPoints[1] + mutualPoints[3]) {
            tempCos = cosAnother;
        } else {
            tempCos = cos;
        }
        if (boundsInParent.getMinY() + rightY < mutualPoints[1] + mutualPoints[3]) {
            tempCosAnother = cos;
        } else {
            tempCosAnother = cosAnother;
        }
        tempHeight = Math.max((int) Math.abs(mutualPoints[1] + mutualPoints[3] - (boundsInParent.getMinY() + leftY)), 2);
        tempHeightRight = Math.max((int) Math.abs(mutualPoints[1] + mutualPoints[3] - (boundsInParent.getMinY() + rightY)), 2);
        if (checkXCollision(mutualPoints, boundsInParent, tempCos, tempCosAnother, tempHeight, tempHeightRight))
            return true;
        //上Y轴判断
        if (boundsInParent.getMinX() + topX < mutualPoints[0]) {
            tempCos = cos;
        } else {
            tempCos = cosAnother;
        }
        if (boundsInParent.getMinX() + bottomX < mutualPoints[0]) {
            tempCosAnother = cosAnother;
        } else {
            tempCosAnother = cos;
        }
        tempHeight = Math.max((int) Math.abs(mutualPoints[0] - (boundsInParent.getMinX() + topX)), 2);
        tempHeightRight = Math.max((int) Math.abs(mutualPoints[0] - (boundsInParent.getMinX() + bottomX)), 2);
        if (checkYCollision(mutualPoints, boundsInParent, tempCos, tempCosAnother, tempHeight, tempHeightRight)) {
            return true;
        }
        //下Y轴判断
        if (boundsInParent.getMinX() + topX < mutualPoints[0] + mutualPoints[2]) {
            tempCos = cos;
        } else {
            tempCos = cosAnother;
        }
        if (boundsInParent.getMinX() + bottomX < mutualPoints[0] + mutualPoints[2]) {
            tempCosAnother = cosAnother;
        } else {
            tempCosAnother = cos;
        }
        tempHeight = Math.max((int) Math.abs(mutualPoints[0] + mutualPoints[2] - (boundsInParent.getMinX() + topX)), 2);
        tempHeightRight = Math.max((int) Math.abs(mutualPoints[0] + mutualPoints[2] - (boundsInParent.getMinX() + bottomX)), 2);
        if (checkYCollision(mutualPoints, boundsInParent, tempCos, tempCosAnother, tempHeight, tempHeightRight)) {
            return true;
        }
        return false;
    }

    private static boolean checkXCollision(int[] mutualPoints, Bounds boundsInParent, double tempCos, double tempCosAnother, int tempHeight, int tempHeightRight) {
        if (!(boundsInParent.getMinX() + Math.sqrt(Math.pow(tempHeight / tempCos, 2) - Math.pow(tempHeight, 2)) > mutualPoints[0] + mutualPoints[2]
                || boundsInParent.getMaxX() - Math.sqrt(Math.pow(tempHeightRight / tempCosAnother, 2) - Math.pow(tempHeightRight, 2)) < mutualPoints[0])) {
            return true;
        }
        return false;
    }

    private static boolean checkYCollision(int[] mutualPoints, Bounds boundsInParent, double tempCos, double tempCosAnother, int tempHeight, int tempHeightRight) {
        if (!(boundsInParent.getMinY() + Math.sqrt(Math.pow(tempHeight / tempCos, 2) - Math.pow(tempHeight, 2)) > mutualPoints[1] + mutualPoints[3]
                || boundsInParent.getMaxY() - Math.sqrt(Math.pow(tempHeightRight / tempCosAnother, 2) - Math.pow(tempHeightRight, 2)) < mutualPoints[1])) {
            return true;
        }
        return false;
    }

    private static boolean isEven(int num) {
        return (num & 1) != 0;
    }

}

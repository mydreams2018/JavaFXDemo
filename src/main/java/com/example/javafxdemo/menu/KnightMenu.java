package com.example.javafxdemo.menu;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class KnightMenu {

    private static final Map<String, List<String>> ALL_LANGUAGE = new HashMap<>();
    private static final Image BUTTON_TYPE_TWO = new Image(KnightMenu.class.getResourceAsStream("button_type2.png"));
    private static final Image BUTTON_TYPE_TWO_YELLOW = new Image(KnightMenu.class.getResourceAsStream("button_type2_yellow.png"));
    private static final Image BUTTON_TYPE_THREE = new Image(KnightMenu.class.getResourceAsStream("button_type3.png"));
    private static final Image BUTTON_TYPE_THREE_YELLOW = new Image(KnightMenu.class.getResourceAsStream("button_type3_yellow.png"));
    private static final Image BUTTON_TYPE_FOUR = new Image(KnightMenu.class.getResourceAsStream("button_type4.png"));
    private static final Image BUTTON_TYPE_FOUR_YELLOW = new Image(KnightMenu.class.getResourceAsStream("button_type4_yellow.png"));
    private static final Image CHOOSE_ELEMENT = new Image(KnightMenu.class.getResourceAsStream("chose_element.png"));

    private static final Image LANGUAGE_BUTTON = new Image(KnightMenu.class.getResourceAsStream("button.png"));
    private static final Image LANGUAGE_BUTTON_YELLOW = new Image(KnightMenu.class.getResourceAsStream("button_yellow.png"));
    private static final ImageView LANGUAGE_BUTTON_CN = new ImageView(LANGUAGE_BUTTON);
    private static final Label LANGUAGE_BUTTON_CN_LABEL = new Label("中文");
    private static final ImageView LANGUAGE_BUTTON_EN = new ImageView(LANGUAGE_BUTTON);
    private static final Label LANGUAGE_BUTTON_EN_LABEL = new Label("english");

    private static boolean LanguageChoiceShow = false;

    private static final int BASE_WIDTH = 346;
    private static final int BASE_HEIGHT = 69;
    private static final ImageView[] BACK_VOLUME_VIEW = new ImageView[20];
    private static final ImageView[] MAIN_VOLUME_VIEW = new ImageView[20];

    private final Pane meunPane = new Pane();
    private final Label[] textLabels;

    private final ImageView buttonIntroductionView = new ImageView(BUTTON_TYPE_TWO);
    private final ImageView buttonLanguageView = new ImageView(BUTTON_TYPE_THREE);
    private final ImageView buttonBackgroundVolumeView = new ImageView(BUTTON_TYPE_FOUR);
    private final ImageView buttonMainVolumeView = new ImageView(BUTTON_TYPE_FOUR);
    private final ImageView buttonKeyboardBindingView = new ImageView(BUTTON_TYPE_TWO);
    private final ImageView buttonLevelIntroductionView = new ImageView(BUTTON_TYPE_TWO);
    private final ImageView buttonRestartView = new ImageView(BUTTON_TYPE_TWO);
    private final ImageView buttonStopView = new ImageView(BUTTON_TYPE_TWO);
    private int backVolume = 4;
    private int mainVolume = 20;

    private String currentLanguage = "中文";

    static {
        List<String> one = List.of("游戏介绍", "语言选择", "背景音量", "全局音量", "按键绑定", "关卡介绍", "重新开始", "结束游戏");
        List<String> two = List.of("Introduction", "Language", "Back Volume", "Main Volume", "Keyboard Binding", "Level Introduction", "Restart", "Stop Game");
        ALL_LANGUAGE.put("中文", one);
        ALL_LANGUAGE.put("english", two);
    }

    public KnightMenu() {
        List<String> stringList = ALL_LANGUAGE.get(this.currentLanguage);
        this.textLabels = new Label[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            this.textLabels[i] = new Label(stringList.get(i));
        }
        this.textLabels[0].setLayoutX(10);
        this.textLabels[0].setLayoutY(20);
        this.textLabels[1].setLayoutX(10 + BASE_WIDTH);
        this.textLabels[1].setLayoutY(20);
        this.textLabels[2].setLayoutX(10);
        this.textLabels[2].setLayoutY(20 + BASE_HEIGHT);
        this.textLabels[3].setLayoutX(10 + BASE_WIDTH);
        this.textLabels[3].setLayoutY(20 + BASE_HEIGHT);
        this.textLabels[4].setLayoutX(10);
        this.textLabels[4].setLayoutY(20 + BASE_HEIGHT * 2);
        this.textLabels[5].setLayoutX(10 + BASE_WIDTH);
        this.textLabels[5].setLayoutY(20 + BASE_HEIGHT * 2);
        this.textLabels[6].setLayoutX(10);
        this.textLabels[6].setLayoutY(20 + BASE_HEIGHT * 3);
        this.textLabels[7].setLayoutX(10 + BASE_WIDTH);
        this.textLabels[7].setLayoutY(20 + BASE_HEIGHT * 3);

        this.buttonLanguageView.setLayoutX(BASE_WIDTH + 1);
        this.buttonBackgroundVolumeView.setLayoutX(1);
        this.buttonBackgroundVolumeView.setLayoutY(BASE_HEIGHT);
        this.buttonMainVolumeView.setLayoutX(BASE_WIDTH + 1);
        this.buttonMainVolumeView.setLayoutY(BASE_HEIGHT);

        this.buttonKeyboardBindingView.setLayoutY(BASE_HEIGHT * 2);
        this.buttonLevelIntroductionView.setLayoutX(BASE_WIDTH);
        this.buttonLevelIntroductionView.setLayoutY(BASE_HEIGHT * 2);

        this.buttonRestartView.setLayoutY(BASE_HEIGHT * 3);
        this.buttonStopView.setLayoutY(BASE_HEIGHT * 3);
        this.buttonStopView.setLayoutX(BASE_WIDTH);

        LANGUAGE_BUTTON_CN.setLayoutX(571);
        LANGUAGE_BUTTON_CN.setLayoutY(BASE_HEIGHT - 10);
        LANGUAGE_BUTTON_CN.setVisible(LanguageChoiceShow);
        LANGUAGE_BUTTON_CN.setViewOrder(-1);
        LANGUAGE_BUTTON_CN_LABEL.setLayoutX(571);
        LANGUAGE_BUTTON_CN_LABEL.setLayoutY(BASE_HEIGHT - 10);
        LANGUAGE_BUTTON_CN_LABEL.setVisible(LanguageChoiceShow);
        LANGUAGE_BUTTON_CN_LABEL.setAlignment(Pos.CENTER);
        LANGUAGE_BUTTON_CN_LABEL.setPrefWidth(109);
        LANGUAGE_BUTTON_CN_LABEL.setPrefHeight(36);
        LANGUAGE_BUTTON_CN_LABEL.setViewOrder(-1);
        LANGUAGE_BUTTON_EN.setLayoutX(571);
        LANGUAGE_BUTTON_EN.setLayoutY(BASE_HEIGHT + 26);
        LANGUAGE_BUTTON_EN.setVisible(LanguageChoiceShow);
        LANGUAGE_BUTTON_EN.setViewOrder(-1);
        LANGUAGE_BUTTON_EN_LABEL.setLayoutX(571);
        LANGUAGE_BUTTON_EN_LABEL.setLayoutY(BASE_HEIGHT + 26);
        LANGUAGE_BUTTON_EN_LABEL.setVisible(LanguageChoiceShow);
        LANGUAGE_BUTTON_EN_LABEL.setAlignment(Pos.CENTER);
        LANGUAGE_BUTTON_EN_LABEL.setPrefWidth(109);
        LANGUAGE_BUTTON_EN_LABEL.setPrefHeight(36);
        LANGUAGE_BUTTON_EN_LABEL.setViewOrder(-1);

        this.meunPane.getChildren().addAll(this.buttonIntroductionView, this.buttonLanguageView, this.buttonBackgroundVolumeView, this.buttonMainVolumeView,
                this.buttonKeyboardBindingView, this.buttonLevelIntroductionView, this.buttonRestartView, this.buttonStopView, this.textLabels[0],
                this.textLabels[1], this.textLabels[2], this.textLabels[3], this.textLabels[4], this.textLabels[5], this.textLabels[6], this.textLabels[7],
                LANGUAGE_BUTTON_CN, LANGUAGE_BUTTON_EN, LANGUAGE_BUTTON_CN_LABEL, LANGUAGE_BUTTON_EN_LABEL);
        this.initMouseEvent();
        this.backgroundVolumeConversion();
        this.mainVolumeConversion();
    }

    public void initMouseEvent() {
        this.buttonIntroductionView.setOnMouseEntered(event -> {
            KnightMenu.this.buttonIntroductionView.setImage(BUTTON_TYPE_TWO_YELLOW);
            KnightMenu.this.buttonIntroductionView.setCursor(Cursor.OPEN_HAND);
        });
        this.buttonIntroductionView.setOnMouseExited(event -> KnightMenu.this.buttonIntroductionView.setImage(BUTTON_TYPE_TWO));

        this.buttonLanguageView.setOnMouseEntered(event -> {
            KnightMenu.this.buttonLanguageView.setImage(BUTTON_TYPE_THREE_YELLOW);
            KnightMenu.this.buttonLanguageView.setCursor(Cursor.OPEN_HAND);
        });
        this.buttonLanguageView.setOnMouseExited(event -> KnightMenu.this.buttonLanguageView.setImage(BUTTON_TYPE_THREE));
        this.buttonLanguageView.setOnMouseClicked(event -> {
            LanguageChoiceShow = !LanguageChoiceShow;
            LANGUAGE_BUTTON_EN.setVisible(LanguageChoiceShow);
            LANGUAGE_BUTTON_CN.setVisible(LanguageChoiceShow);
            LANGUAGE_BUTTON_EN_LABEL.setVisible(LanguageChoiceShow);
            LANGUAGE_BUTTON_CN_LABEL.setVisible(LanguageChoiceShow);
        });
        LANGUAGE_BUTTON_CN_LABEL.setOnMouseEntered(event -> {
            LANGUAGE_BUTTON_CN.setImage(LANGUAGE_BUTTON_YELLOW);
            LANGUAGE_BUTTON_CN_LABEL.setCursor(Cursor.OPEN_HAND);
        });
        LANGUAGE_BUTTON_CN_LABEL.setOnMouseExited(event -> LANGUAGE_BUTTON_CN.setImage(LANGUAGE_BUTTON));
        LANGUAGE_BUTTON_CN_LABEL.setOnMouseClicked(event -> {
            KnightMenu.this.currentLanguage = "中文";
            KnightMenu.this.LanguageConversion();
        });

        LANGUAGE_BUTTON_EN_LABEL.setOnMouseEntered(event -> {
            LANGUAGE_BUTTON_EN.setImage(LANGUAGE_BUTTON_YELLOW);
            LANGUAGE_BUTTON_EN_LABEL.setCursor(Cursor.OPEN_HAND);
        });
        LANGUAGE_BUTTON_EN_LABEL.setOnMouseExited(event -> LANGUAGE_BUTTON_EN.setImage(LANGUAGE_BUTTON));
        LANGUAGE_BUTTON_EN_LABEL.setOnMouseClicked(event -> {
            KnightMenu.this.currentLanguage = "english";
            KnightMenu.this.LanguageConversion();
        });


        this.buttonBackgroundVolumeView.setOnMouseEntered(event -> {
            KnightMenu.this.buttonBackgroundVolumeView.setImage(BUTTON_TYPE_FOUR_YELLOW);
            KnightMenu.this.buttonBackgroundVolumeView.setCursor(Cursor.OPEN_HAND);
        });
        this.buttonBackgroundVolumeView.setOnMouseExited(event -> KnightMenu.this.buttonBackgroundVolumeView.setImage(BUTTON_TYPE_FOUR));
        this.buttonBackgroundVolumeView.setOnMouseClicked(event -> {
            double eventX = event.getX();
            if (eventX >= 115 && eventX <= 130) {
                KnightMenu.this.setBackVolume(KnightMenu.this.getBackVolume() - 1);
                KnightMenu.this.backgroundVolumeConversion();
            } else if (eventX >= 315 && eventX <= 330) {
                KnightMenu.this.setBackVolume(KnightMenu.this.getBackVolume() + 1);
                KnightMenu.this.backgroundVolumeConversion();
            }
        });

        this.buttonMainVolumeView.setOnMouseEntered(event -> {
            KnightMenu.this.buttonMainVolumeView.setImage(BUTTON_TYPE_FOUR_YELLOW);
            KnightMenu.this.buttonMainVolumeView.setCursor(Cursor.OPEN_HAND);
        });
        this.buttonMainVolumeView.setOnMouseExited(event -> KnightMenu.this.buttonMainVolumeView.setImage(BUTTON_TYPE_FOUR));
        this.buttonMainVolumeView.setOnMouseClicked(event -> {
            double eventX = event.getX();
            if (eventX >= 115 && eventX <= 130) {
                KnightMenu.this.setMainVolume(KnightMenu.this.getMainVolume() - 1);
                KnightMenu.this.mainVolumeConversion();
            } else if (eventX >= 315 && eventX <= 330) {
                KnightMenu.this.setMainVolume(KnightMenu.this.getMainVolume() + 1);
                KnightMenu.this.mainVolumeConversion();
            }
        });

        this.buttonKeyboardBindingView.setOnMouseEntered(event -> {
            KnightMenu.this.buttonKeyboardBindingView.setImage(BUTTON_TYPE_TWO_YELLOW);
            KnightMenu.this.buttonKeyboardBindingView.setCursor(Cursor.OPEN_HAND);
        });
        this.buttonKeyboardBindingView.setOnMouseExited(event -> KnightMenu.this.buttonKeyboardBindingView.setImage(BUTTON_TYPE_TWO));

        this.buttonLevelIntroductionView.setOnMouseEntered(event -> {
            KnightMenu.this.buttonLevelIntroductionView.setImage(BUTTON_TYPE_TWO_YELLOW);
            KnightMenu.this.buttonLevelIntroductionView.setCursor(Cursor.OPEN_HAND);
        });
        this.buttonLevelIntroductionView.setOnMouseExited(event -> KnightMenu.this.buttonLevelIntroductionView.setImage(BUTTON_TYPE_TWO));

        this.buttonRestartView.setOnMouseEntered(event -> {
            KnightMenu.this.buttonRestartView.setImage(BUTTON_TYPE_TWO_YELLOW);
            KnightMenu.this.buttonRestartView.setCursor(Cursor.OPEN_HAND);
        });
        this.buttonRestartView.setOnMouseExited(event -> KnightMenu.this.buttonRestartView.setImage(BUTTON_TYPE_TWO));

        this.buttonStopView.setOnMouseEntered(event -> {
            KnightMenu.this.buttonStopView.setImage(BUTTON_TYPE_TWO_YELLOW);
            KnightMenu.this.buttonStopView.setCursor(Cursor.OPEN_HAND);
        });
        this.buttonStopView.setOnMouseExited(event -> KnightMenu.this.buttonStopView.setImage(BUTTON_TYPE_TWO));
    }


    public void LanguageConversion() {
        List<String> stringLanguage = ALL_LANGUAGE.get(this.currentLanguage);
        for (int i = 0; i < this.textLabels.length; i++) {
            this.textLabels[i].setText(stringLanguage.get(i));
        }
    }

    public void backgroundVolumeConversion() {
        for (int i = backVolume; i < BACK_VOLUME_VIEW.length; i++) {
            ImageView imageView = BACK_VOLUME_VIEW[i];
            if (imageView != null) {
                this.meunPane.getChildren().remove(imageView);
            }
        }
        int baseWidth = 8;
        int baseX = 145;
        int baseY = 78;
        for (int i = 0; i < backVolume; i++) {
            ImageView imageView = BACK_VOLUME_VIEW[i];
            if (imageView == null) {
                imageView = new ImageView(CHOOSE_ELEMENT);
                BACK_VOLUME_VIEW[i] = imageView;
            }
            imageView.setLayoutX(baseX + i * baseWidth);
            imageView.setLayoutY(baseY);
            if (!this.meunPane.getChildren().contains(imageView)) {
                this.meunPane.getChildren().add(imageView);
            }
        }
    }

    public void mainVolumeConversion() {
        for (int i = mainVolume; i < MAIN_VOLUME_VIEW.length; i++) {
            ImageView imageView = MAIN_VOLUME_VIEW[i];
            if (imageView != null) {
                this.meunPane.getChildren().remove(imageView);
            }
        }
        int baseWidth = 8;
        int baseX = 145 + BASE_WIDTH;
        int baseY = 78;
        for (int i = 0; i < mainVolume; i++) {
            ImageView imageView = MAIN_VOLUME_VIEW[i];
            if (imageView == null) {
                imageView = new ImageView(CHOOSE_ELEMENT);
                MAIN_VOLUME_VIEW[i] = imageView;
            }
            imageView.setLayoutX(baseX + i * baseWidth);
            imageView.setLayoutY(baseY);
            if (!this.meunPane.getChildren().contains(imageView)) {
                this.meunPane.getChildren().add(imageView);
            }
        }
    }

    public void setBackVolume(int backVolume) {
        if (backVolume < 0) {
            this.backVolume = 0;
        } else if (backVolume > 20) {
            this.backVolume = 20;
        } else {
            this.backVolume = backVolume;
        }
    }

    public void setMainVolume(int mainVolume) {
        if (mainVolume < 0) {
            this.mainVolume = 0;
        } else if (mainVolume > 20) {
            this.mainVolume = 20;
        } else {
            this.mainVolume = mainVolume;
        }
    }
}

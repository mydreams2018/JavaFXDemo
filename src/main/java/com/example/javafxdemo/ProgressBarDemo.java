package com.example.javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ProgressBarDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle p1 = new Rectangle(10,10,100,10);
        p1.setStrokeWidth(1);
        p1.setArcHeight(3);
        p1.setArcWidth(3);
        p1.setStroke(Color.GREEN);
        p1.setFill(Color.color(0,0,0,0));

        Rectangle p2 = new Rectangle(11,11,60,8);
        p2.setFill(Color.RED);

//        p1.setStyle("-fx-accent: red; -fx-indeterminate-bar-length: 200;");
//        p1.setPrefWidth(60);
//        p1.setPrefHeight(10);
        Group group = new Group();
        group.getChildren().addAll(p1,p2);
        Scene scene = new Scene(group, 1366, 768);
        scene.setFill(Color.HONEYDEW);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*
        *
       [CSSProperty {
    property: -fx-indeterminate-bar-animation-time, converter: SizeConverter, initalValue: 2.0, inherits: false, subProperties: []}
,
CSSProperty {

    property: -fx-region-border,
    converter: BorderConverter,
    initalValue: null,
    inherits: false,
    subProperties: [CSSProperty {
        property: -fx-border-color, converter: LayeredBorderPaintConverter, initalValue: null, inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-style, converter: LayeredBorderStyleConverter, initalValue: null, inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-width, converter: MarginsSequenceConverter, initalValue: null, inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-radius, converter: com.sun.javafx.scene.layout.region.CornerRadiiConverter@415ae41f, initalValue: null, inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-insets, converter: InsetsSequenceConverter, initalValue: null, inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-image-source, converter: URLSeqType, initalValue: null, inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-image-repeat, converter: RepeatStructConverter, initalValue: [Lcom.sun.javafx.scene.layout.region.RepeatStruct;
        @68b4d3dc,
        inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-image-slice, converter: BorderImageSliceSequenceConverter, initalValue: [Lcom.sun.javafx.scene.layout.region.BorderImageSlices;
        @7abba89,
        inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-image-width, converter: BorderImageWidthConverter, initalValue: [Ljavafx.scene.layout.BorderWidths;
        @2b0e4827,
        inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-border-image-insets, converter: InsetsSequenceConverter, initalValue: [Ljavafx.geometry.Insets;
        @3d623b45,
        inherits: false, subProperties: []
    }

    ]
}

,
CSSProperty {
    property: -fx-pref-height, converter: SizeConverter, initalValue: -1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-effect, converter: EffectConverter, initalValue: null, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-indeterminate-bar-flip, converter: BooleanConverter, initalValue: true, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-padding, converter: InsetsConverter, initalValue: Insets [top=0.0, right=0.0, bottom=0.0, left=0.0], inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-skin, converter: StringConverter, initalValue: null, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-blend-mode, converter: EnumConverter[javafx.scene.effect.BlendMode], initalValue: null, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-scale-shape, converter: BooleanConverter, initalValue: true, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-max-width, converter: SizeConverter, initalValue: -1.0, inherits: false, subProperties: []
}

,
CSSProperty {

    property: -fx-region-background,
    converter: javafx.scene.layout.BackgroundConverter@3e2d30,
    initalValue: null,
    inherits: false,
    subProperties: [CSSProperty {
        property: -fx-background-color, converter: Paint.SequenceConverter, initalValue: [Ljavafx.scene.paint.Paint;
        @89fc2ac,
        inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-background-insets, converter: InsetsSequenceConverter, initalValue: [Ljavafx.geometry.Insets;
        @33fb9090,
        inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-background-radius, converter: com.sun.javafx.scene.layout.region.CornerRadiiConverter@415ae41f, initalValue: [Ljavafx.scene.layout.CornerRadii;
        @6cd7dd15,
        inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-background-image, converter: URLSeqType, initalValue: null, inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-background-repeat, converter: RepeatStructConverter, initalValue: [Lcom.sun.javafx.scene.layout.region.RepeatStruct;
        @1d713a12,
        inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-background-position, converter: LayeredBackgroundPositionConverter, initalValue: [Ljavafx.scene.layout.BackgroundPosition;
        @6b8d11b2,
        inherits: false, subProperties: []
    }

    ,
    CSSProperty {
        property: -fx-background-size, converter: com.sun.javafx.scene.layout.region.LayeredBackgroundSizeConverter@49d7343, initalValue: [Ljavafx.scene.layout.BackgroundSize;
        @56f039b0,
        inherits: false, subProperties: []
    }

    ]
}

,
CSSProperty {
    property: -fx-min-width, converter: SizeConverter, initalValue: -1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-snap-to-pixel, converter: BooleanConverter, initalValue: true, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-focus-traversable, converter: BooleanConverter, initalValue: false, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-scale-x, converter: SizeConverter, initalValue: 1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-min-height, converter: SizeConverter, initalValue: -1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-rotate, converter: SizeConverter, initalValue: 0.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: visibility, converter: javafx.scene.Node$StyleableProperties$14@42c538d6, initalValue: true, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-position-shape, converter: BooleanConverter, initalValue: true, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-max-height, converter: SizeConverter, initalValue: -1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-opaque-insets, converter: InsetsConverter, initalValue: null, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-indeterminate-bar-escape, converter: BooleanConverter, initalValue: true, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-shape, converter: javafx.css.converter.ShapeConverter@41c6a1bd, initalValue: null, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-opacity, converter: SizeConverter, initalValue: 1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-cursor, converter: CursorConverter, initalValue: null, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-scale-z, converter: SizeConverter, initalValue: 1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-scale-y, converter: SizeConverter, initalValue: 1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-indeterminate-bar-length, converter: SizeConverter, initalValue: 60.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-translate-y, converter: SizeConverter, initalValue: 0.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-translate-z, converter: SizeConverter, initalValue: 0.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-translate-x, converter: SizeConverter, initalValue: 0.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-pref-width, converter: SizeConverter, initalValue: -1.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-view-order, converter: SizeConverter, initalValue: 0.0, inherits: false, subProperties: []
}

,
CSSProperty {
    property: -fx-managed, converter: BooleanConverter, initalValue: true, inherits: false, subProperties: []
}

         * */

        System.out.println(p1.getBlendMode());
        //https://hg.openjdk.org/openjfx/2.2/master/rt/raw-file/tip/javafx-ui-controls/src/com/sun/javafx/scene/control/skin/caspian/caspian.css
        System.out.println(Application.STYLESHEET_CASPIAN);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

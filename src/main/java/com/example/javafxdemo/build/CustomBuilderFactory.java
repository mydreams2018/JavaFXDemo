package com.example.javafxdemo.build;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class CustomBuilderFactory implements BuilderFactory {

    private static final BuilderFactory DEFAULT_BUILDER_FACTORY = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type.equals(CustomData.class)) {
            return new CustomBuilder();
        }
        return DEFAULT_BUILDER_FACTORY.getBuilder(type);
    }

}

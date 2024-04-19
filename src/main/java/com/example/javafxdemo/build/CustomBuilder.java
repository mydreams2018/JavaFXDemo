package com.example.javafxdemo.build;

import javafx.util.Builder;

public class CustomBuilder implements Builder<CustomData> {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public CustomData build() {
        return new CustomData(id, name);
    }

    /*  自定义的类加在 FXML
    * <CustomData id="" name="" >  </CustomData>
    * */

}

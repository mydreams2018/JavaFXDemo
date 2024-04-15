package com.example.javafxdemo;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListBindDemo {

    /*
     * 集合数据绑定
     * */
    public static void main(String[] args) {

        ObservableList<String> stringObservableList = FXCollections.observableArrayList("Hello", "World", "你好", "世界");
        SimpleListProperty<String> simpleListProperty = new SimpleListProperty<>(stringObservableList);

        System.out.println(simpleListProperty.getFirst());//Hello
        System.out.println(simpleListProperty.getLast());//世界

        //绑定固定索引
        ObjectBinding<String> fixedBinding = simpleListProperty.valueAt(0);
        System.out.println(fixedBinding.get());//Hello

        simpleListProperty.set(0, "游戏");

        System.out.println(fixedBinding.get());//游戏

        //绑定可变索引
        SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty(0);
        ObjectBinding<String> changeableBinding = simpleListProperty.valueAt(simpleIntegerProperty);
        System.out.println(changeableBinding.get());

        /*
        * Creates a StringExpression that holds the value of multiple Objects formatted according to a format String.
        *   If one of the arguments implements ObservableValue and the value of this ObservableValue changes,
        *   the change is automatically reflected in the StringExpression.
        * */
        SimpleIntegerProperty simpleIntegerPro = new SimpleIntegerProperty(666);
        //格式化绑定
        StringExpression format = Bindings.format("int = %d", simpleIntegerPro);
        System.out.println(format.get());//int = 666

        simpleIntegerPro.set(999);
        System.out.println(format.get());//int = 999
    }
}

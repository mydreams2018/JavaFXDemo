package com.example.javafxdemo;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.When;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindCountDemo {

    /*
    * 多源 绑定计算
    * */
    public static void main(String[] args) {
        SimpleIntegerProperty s1 = new SimpleIntegerProperty(10);
        SimpleIntegerProperty s2 = new SimpleIntegerProperty(20);

        //绑定计算 返回的对象中包含 s1 s2 引用   Bindings.add(s1, s2)
        NumberBinding addBind = s1.add(s2);
        System.out.println(addBind.intValue());//30

        s1.set(60);
        System.out.println(addBind.intValue());//80

        //绑定计算 返回的对象中包含 s1 s2 引用 Bindings.lessThan(s1, s2)  s1 < s2
        BooleanBinding booleanBinding = s1.lessThan(s2);
        System.out.println(booleanBinding.get());
        //s1 <= s2
        BooleanBinding lessThanOrEqualTo = s1.lessThanOrEqualTo(s2);
        System.out.println(lessThanOrEqualTo.get());

        SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty(false);
        When when = new When(simpleBooleanProperty);
        //三目运算 表达示
        NumberBinding otherwise = when.then(10).otherwise(20);
        System.out.println(otherwise.getValue());//20
        simpleBooleanProperty.set(true);
        System.out.println(otherwise.getValue());//10
    }
}

package com.example.javafxdemo;

import javafx.beans.property.SimpleIntegerProperty;

public class BidirectionalBind {

    /*
    * 单向绑定  双向绑定   集合类绑定特性有所区别 需要注意
    * */
    public static void main(String[] args) {
        SimpleIntegerProperty s1 = new SimpleIntegerProperty(10);
        SimpleIntegerProperty s2 = new SimpleIntegerProperty(20);
        singleBind(s1, s2);
//        bidirectionalBind(s1, s2);
    }

    public static void singleBind(SimpleIntegerProperty s1, SimpleIntegerProperty s2) {
        System.out.println(s1.get());
        System.out.println(s2.get());
        //s1 绑定到 s2 绑定以后不允许再主动修改s1
        s1.bind(s2);
        System.out.println(s1.isBound());//true
        System.out.println(s1.get());
        System.out.println(s2.get());

        s2.setValue(666);

        System.out.println(s1.get());//666
        System.out.println(s2.get());//666
    }

    public static void bidirectionalBind(SimpleIntegerProperty s1, SimpleIntegerProperty s2) {
        System.out.println(s1.get());
        System.out.println(s2.get());
        //s1 绑定到 s2 绑定以后不允许再主动修改s1
        s1.bindBidirectional(s2);
        System.out.println(s1.isBound());//false
        System.out.println(s2.isBound());//false
        System.out.println(s1.get());
        System.out.println(s2.get());

        s2.setValue(666);
        System.out.println(s1.get());
        System.out.println(s2.get());

        s1.setValue(999);
        System.out.println(s1.get());
        System.out.println(s2.get());
    }
}

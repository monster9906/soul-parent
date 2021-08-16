package com.soul.container;

import java.util.ArrayList;

/**
 * @author LingCoder
 * @Description: list 必须按插入的顺序保存元素 set不能有重复元素 Queue按照排队规则来确定对象产生的顺序
 * @Date 2020/11/6-11:49
 */
class Apple{
    private static long counter;
    private final long id = counter++;
    public long id(){
        return id;
    }
}

class Orange{}

class GrannySmith extends Apple{}
class Gala extends Apple{}
class Fuji extends Apple{}
class Braeburn extends Apple{}

public class ApplesAndOrangesWithOutGenerics {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();

        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());

        for (Apple apple : apples) {
            System.out.println(apple);
        }

    }

}

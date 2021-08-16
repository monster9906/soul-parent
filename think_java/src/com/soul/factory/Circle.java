package com.soul.factory;

/**
 * @author Rich_fu
 * @date 2021/3/22
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("画一个圆");
    }

    @Override
    public void erase() {
        System.out.println("清除所画的圆");
    }
}

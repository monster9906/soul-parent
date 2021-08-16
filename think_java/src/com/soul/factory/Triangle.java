package com.soul.factory;

/**
 * @author Rich_fu
 * @date 2021/3/22
 */
public class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("画一个三角形");
    }

    @Override
    public void erase() {
        System.out.println("清除一个三角形");
    }
}

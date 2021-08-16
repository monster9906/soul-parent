package com.soul.factory;

/**
 * @author Rich_fu
 * @date 2021/3/23
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();
        circle.erase();
        Shape rectangle = ShapeFactory.getShape("rectangle");
        rectangle.draw();
        rectangle.erase();
        Shape triangle = ShapeFactory.getShape("triangle");
        triangle.draw();
        triangle.erase();
        Shape err = ShapeFactory.getShape("err");
        err.draw();
        err.erase();
    }

}

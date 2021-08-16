package com.soul.factory;

/**
 * @author Rich_fu
 * @date 2021/3/22
 */
public class ShapeFactory {
    public static Shape getShape(String type) throws Exception {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        }else if (type.equalsIgnoreCase("triangle")){
            return new Triangle();
        }else if (type.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }else {
            throw new Exception("UnsupportedShapeException ");
        }
    }
}

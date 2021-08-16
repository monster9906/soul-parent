package com.soul.exception;

/**
 * @author LingCoder
 * @Description: 多个点返回
 * @Date 2020/11/16-17:07
 */
public class MultipleReturns {
    public static void f(int i){
        System.out.println("需要清除后 才能初始化");

        try {
            System.out.println("Point1");
            if(i == 1) return;
            System.out.println("Point2");
            if(i == 2) return;
            System.out.println("Point3");
            if(i == 3) return;
            System.out.println("end");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("执行清理...");
        }
    }

    public static void main(String[] args) {
        // finally内部，从何处返回无关紧要
        for (int i = 0; i < 4; i++) {
            f(i);
        }
    }
}

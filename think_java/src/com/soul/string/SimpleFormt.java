package com.soul.string;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/12-22:26
 */
public class SimpleFormt {
    public static void main(String[] args) {
        int x = 10;
        double y = 5.22365;
        System.out.printf("Row1: [%d,%f]\n",x,y);
        System.out.format("Row1: [%d,%f]\n",x,y);
    }
}

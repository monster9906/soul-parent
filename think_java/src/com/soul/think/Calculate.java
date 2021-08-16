package com.soul.think;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/20-17:16
 */
public class Calculate {
    public int add(int a, int b) {
        System.out.println(a+b);
        return (a + b);
    }

    public int subtract(int a, int b) {
        System.out.println(a-b);
        return (a - b);
    }


    public int multiply(int a, int b) {
        System.out.println(a*b);
        return (a * b);
    }

    public int divide(int a, int b) {
        if (b == 0) {
            System.out.print("分母不能为0");
            return 0;
        } else {
            System.out.println(a / b );
            return (a / b);
        }
    }

}

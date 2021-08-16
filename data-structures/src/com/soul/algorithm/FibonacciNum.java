package com.soul.algorithm;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:给定一个非负整数n,计算第n个Fibonacci数。
 * @Date 2020/9/28-16:33 0 1 1 2 3 5
 */
public class FibonacciNum {
    private static int count = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入非负整数n:");
        int n = scanner.nextInt();
        System.out.println("递归方式所求Fibonacci数：" + fib(n));
        System.out.println("递归执行的次数：" + count);
        // 重置次数
        count = 1;
        System.out.println("迭代方式所求Fibonacci数：" + fibByIteration(n));
        System.out.println("迭代执行的次数：" + count);
        maxNumAndTime();
        max_int_iteration();

    }

    /**
     * @return int
     * @author LingCoder
     * @date 2020/9/28 16:35
     * @description: 递归算法
     */
    private static int fib(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            // 次数累加
            count++;
            return fib(n - 1) + fib(n - 2);
        }

    }

    /**
     * @return void
     * @author LingCoder
     * @date 2020/9/28 19:23
     * @description: 递归求不超过计算机最大整数的n
     */
    private static void maxNumAndTime() {
        int f = 0, i = 0, t = 0;
        long time = 0; // 执行时间
        long currentTimeMillis = System.currentTimeMillis();

        // 超出回内存溢出变为负数
        while (2 * t >= 0) {
            t = f;
            f = fib(i);
            i++;
        }

        time = System.currentTimeMillis() - currentTimeMillis;

        System.out.println("最大数：" + i + " 执行时间" + time);
    }

    /**
     * @return int
     * @author LingCoder
     * @date 2020/9/28 19:19
     * @description: 迭代求不超过计算机最大整数的n
     */
    public static void max_int_iteration() {
        int a = 1, b = 1, c = 2;
        int count = 3;
        // 执行时间
        long time = 0;
        long currentTimeMillis = System.currentTimeMillis();

        for (; b < c; ) {   //达到编程环境最大斐波那契数，便会产生内存溢出，从而变成一个负数，到此循环结束
            a = b;
            b = c;
            c = a + b;
            count++;
        }
        time = System.currentTimeMillis() - currentTimeMillis;

        System.out.println("最大数：" + count + " 执行时间" + time);

    }


    /**
     * @return int
     * @author LingCoder
     * @date 2020/9/28 16:53
     * @description: 迭代方式
     */
    private static int fibByIteration(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // 上一个数
        int last = 1;
        // 上上一个数 第一个数
        int lastLast = 0;
        // 结果
        int result = 0;

        for (int i = 1; i < n; i++) {
            result = last + lastLast;
            // 上一个赋值给上上一个
            lastLast = last;
            // 当前结果赋值给上一个
            last = result;
            count++;
        }
        return result;
    }


}

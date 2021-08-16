package com.soul.think;

import java.util.Random;

/**
 * @author LingCoder
 * @Description:
 * @Date 2021/1/16-21:51
 */
public class FibTest {
    private volatile double l;
    private int nloops;
    private int[] input;

    public static void main(String[] args) {
        FibTest fibTest = new FibTest(5);
        fibTest.doTest(true);
        fibTest.doTest(false);
    }
    private FibTest(int n){
        this.nloops = n ;
        input = new  int[nloops];
        Random random = new Random();
        for (int i = 0; i < nloops; i++) {
            input[i] = random.nextInt(100);
        }
    }

    private void doTest(boolean isWarmup){
        long then = System.currentTimeMillis();
        for (int i = 0; i < nloops; i++) {
            l = fibImpl(input[i]);
        }
        if(! isWarmup){
            long currentTimeMillis = System.currentTimeMillis();
            System.out.println("time consuming"+(currentTimeMillis-then));
        }
    }

    private double fibImpl(int n){
        if (n < 0 ) throw new IllegalArgumentException("must be > 0");
        if (n == 0) return 0;
        if (n == 1) return 1;
        double d = fibImpl(n-1) +fibImpl(n-2);
        if(Double.isInfinite(d)) throw new ArithmeticException("overFlow");
        return d;
    }

}

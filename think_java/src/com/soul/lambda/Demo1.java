package com.soul.lambda;

/**
 * @author 符浩灵
 * @date 2020/7/25 10:50
 */
public class Demo1 {
    static IntCall fact;

    /**
     * 整数 n 的阶乘将所有小于或等于 n 的正整数相乘。
     * @param args
     */
    public static void main(String[] args) {
        new com.xnx3.wuye.client.ui.PrintJframe().printPreview("C:\\Users\\soul\\Pictures\\爱壁纸UWP\\设计");

//        fact = n-> n== 0? 1 : n*fact.call(n-1);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(fact.call(i));
//        }
    }

}


interface IntCall{
    int call(int arg);
}

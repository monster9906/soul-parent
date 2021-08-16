package com.soul.think;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/18-21:40
 *
 *   *  Q  *  *
 *   *  *  *  Q
 *   Q  *  *  *
 *   *  *  Q  *
 *
 *   *  *  Q  *
 *   Q  *  *  *
 *   *  *  *  Q
 *   *  Q  *  *
 *4皇后问题共有2种摆放方案
 */
public class Queue8 {

    private static int max = 0;

    // 存放的位置 下标i+1表示第几行，对应的value值表示皇后放的位置
    int[] arr = new int[max];

    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        max = nextInt;
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("%d皇后问题共有%d种摆放方案\n",nextInt,count);
    }

    /**
     * @author LingCoder
     * @date 2020/11/18 22:10
     * @description: 进第n个皇后放到对应位置
     */
    private void check(int n){
        if(n == max){
            print();
            return;
        }
        // 放入
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后放到当前行的第一列
            arr[n] = i;
            if(judge(n)){ // 位置不冲突
                // 接着放后面的皇后 开始递归
                check(n+1);
            }
            // 如果冲突，继续执行arr[n] = i  此时i加1  表示往后移动一列了
        }
    }


    /**
     * @author LingCoder
     * @date 2020/11/18 21:43
     * @description: 打印输出
     */
    private void print(){
        count ++;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] == j){
                    System.out.print("  Q");
                }else {
                    System.out.print("  *");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * @author LingCoder
     * @date 2020/11/18 21:57
     * @description:  判断放置的位置是否符合位置
     * @param n 表示第几个皇后
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])){ // 在同一列 或者是斜对角
                return false;
            }
        }
        return true;
    }
}

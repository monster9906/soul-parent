package com.soul.think;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * 5
 * 9     0     0     0    0
 * 12    15    0     0    0
 * 10    6     8     0    0
 * 2    18     9    5     0
 * 19    7     10   4   16
 *
 * max=59
 * 数值和最大的路径是：9->12->10->18->10
 * @Date 2020/11/23-16:49
 */
public class Numtower {

    public static void main(String[] args) {
        int data[][] = {
                {9, 0, 0, 0, 0},
                {12, 15, 0, 0, 0},
                {10, 6, 8, 0, 0},
                {2, 18, 9, 5, 0},
                {19, 7, 10, 4, 16}
        };

        int[][] ints = numberTower(data);

        int i = 0, pre = 0;
        System.out.println("max="+ints[0][0]);
        System.out.print("数值和最大的路径是：" + data[i][pre]);
        for (i = 1; i < ints.length - 1; i++) {
            int node_value = ints[i - 1][pre] - data[i - 1][pre];//默认选中的是左孩子
            if (node_value == ints[i][pre + 1]) {//如果发现选中的是右孩子，那么pre加1
                pre = pre + 1;
            }
            System.out.print("->" + data[i][pre]);
        }
    }

    private static int[][] numberTower(int[][] data){
        int length = data.length;
        int width = data[length-1].length;
        int[][] dp = new int[length + 1][width];//比原来的数塔多一层傀儡层

        // dp初始化
        for (int i = 0; i < width; ++i) {//需要给倒数第二层初始化赋值
            dp[length - 1][i] = data[length - 1][i];
        }
        for (int i = length - 1; i >= 0; i--)
            for (int j = 0; j < data[i].length - 1; j++)
                dp[i][j] = (dp[i + 1][j] > dp[i + 1][j + 1] ? dp[i + 1][j] : dp[i + 1][j + 1]) + data[i][j];
        return dp;
    }
}

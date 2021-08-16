package com.soul.think;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description: 用动态规划解决最大字段和问题。
 * @Date 2020/12/7-16:24
 * 6
 * -2 11 -4 13 -5 -2
 * 20
 */
public class MaxSubSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] data = new int[num];
        for (int i = 0; i < num; i++) {
            data[i] = scanner.nextInt();
        }
//        int[] data = new int[]{-2,11,-4,13,-5,-2};
//        int[] data = {-6,2,4,-7,5,3,2,-1,6,-9,10,-2};
        int i = maxSum(data);

        System.out.println(i);
    }

    private static int maxSum(int[] arr){
        int[] ints = new int[arr.length];
        int max = 0;
        ints[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 前面的数大于0的时候才会出现字段字段和
            ints[i] = ints[i-1] > 0 ? ints[i-1] + arr[i] : arr[i];
            if(ints[i] > max){
                max = ints[i];
            }
        }
        return max;
    }
}

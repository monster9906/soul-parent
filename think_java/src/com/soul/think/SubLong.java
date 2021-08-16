package com.soul.think;

import java.util.Scanner;

/**
 * @author LingCoder
 * @Description: 求最长的单调递增子序列长度
 * @Date 2020/12/7-17:02
 */
public class SubLong {
    public static void main(String[] args) {
        // int[] data = {3,18, 7 ,14, 10, 12, 23, 41, 16, 24};
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] data = new int[num];
        for (int i = 0; i < num; i++) {
            data[i] = scanner.nextInt();
        }
        int i = subLong(data);
        System.out.println(i);

    }
    private static int subLong(int[] arr){
        int[] ints = new int[arr.length];
        ints[0] = arr[0];
        int maxLength = 0;
        for (int i = 1; i < arr.length; i++) {
            if(ints[maxLength] < arr[i]){
                ints[++maxLength] = arr[i];
            }else {
                int left = 0 ;
                int right = maxLength;
                while (left < right){
                    int mid = (left+right) / 2;
                    if(ints[mid] < arr[i]){
                        left = mid +1;
                    }else {
                        right = mid -1;
                    }
                }
                if (ints[left] < arr[i] && (left + 1) < ints.length) {
                    ints[left + 1] = arr[i];
                } else {
                    ints[left] = arr[i];
                }
            }
        }
        return maxLength+1;
    }



}

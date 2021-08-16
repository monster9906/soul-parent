package com.soul.think;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description: 基数排序
 * @Date 2020/11/29-16:56
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }
    private static void radixSort(int[] arr){
        // 先找到数组的最大数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        // 最大数组的长度
        int maxLength = (max+"").length();

        // 定义桶 二维数组
        int[][] bucket = new int[10][arr.length];

        // 定义记录每个桶个数的数组
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n=1; i < maxLength; i++,n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] /n % 10;// 个位数
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 遍历每一个通 并将桶中的数据放入原数组
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 只有当桶里有数据的时候才会遍历
                if(bucketElementCounts[k] != 0){
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }

                // 需要将记录每个桶个数的置为0
                bucketElementCounts[k] = 0 ;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

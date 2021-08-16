package com.soul.think;

import java.util.Arrays;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/24-22:56
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] data = {0,-1,2,1,4,3,7,6,9,8};
        shellSort(data);
    }

    private static void shellSort(int[] data){
        // gap 表示增量，增量逐步缩小
        for (int gap = data.length/2; gap >0;gap/=2) {
            int temp = 0;

            // 将分组的元素判断是否需要调换位置
            for (int i = gap; i <data.length; i++) {
                for (int j = i-gap; j >=0 ; j-= gap) {
                    // 交换元素
                    if(data[j] > data[j+gap]){
                        temp = data[j];
                        data[j] = data[j+gap];
                        data[j+gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序后"+ Arrays.toString(data));
        }
    }

    /**
     * @author LingCoder
     * @date 2020/11/25 13:13
     * @description: 移位发实现希尔排序
     */
    private static void shellSort2(int[] data){
        for (int gap = data.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i < data.length; i++) {
                int j = i;
                int temp = data[j];
                if(data[j] < data[j-gap]){
                    while (j-gap >= 0 && temp < data[j-gap]){
                        // 移动操作
                        data[j] = data[j-gap];
                        j -= gap;
                    }

                    // while循环结束就找到插入的位置
                    data[j] = temp;
                }
            }
        }
    }
}
